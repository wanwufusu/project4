package com.stylefeng.guns.order.modular.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.cinema.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.order.common.exception.OrderException;
import com.stylefeng.guns.order.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;
import com.stylefeng.guns.order.common.persistence.model.Seat;
import com.stylefeng.guns.order.common.persistence.service.OrderService;
import com.stylefeng.guns.util.JsonUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/11
 * @since 1.0.0
 */
@Component
@Service(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    MoocOrderTMapper moocOrderTMapper;

    Jedis redis = new Jedis("182.61.60.156",6379);


    @Override
    public OrderResponseVO<MoocOrder> buyTickets(int fieldId, String soldSeats, String seatsName, String username) {
        String seatPath = moocOrderTMapper.selectHallSeat(fieldId);
        String[] soldSeat = soldSeats.split(",");
        String hasSold = soldSeats(fieldId);
        for (String s : soldSeat) {
            if (!isLegalSeat(s,seatPath)){
                throw new GunsException(OrderException.POST_ORDER_ERROR);
            }
            if (hasSold.contains(s)){
                throw new GunsException(OrderException.POST_ORDER_ERROR);
            }
        }
        String orderId = UUID.randomUUID().toString().replace("-", "");
        Map<String, Object> findByField = moocOrderTMapper.selectOrderNeedInfoByField(fieldId);

        MoocOrder moocOrder = new MoocOrder();
        moocOrder.setOrderId(orderId);
        moocOrder.setCinemaName((String) findByField.get("cinemaName"));
        String cinemaId = String.valueOf(findByField.get("cinemaId"));
        moocOrder.setFieldTime((String) findByField.get("fieldTime"));
        moocOrder.setFilmName((String) findByField.get("filmName"));
        String filmId = String.valueOf(findByField.get("filmId"));
        Double filmPrice = Double.valueOf(String.valueOf(findByField.get("filmPrice")));
        double orderPrice = filmPrice * soldSeats.split(",").length;
        moocOrder.setOrderPrice(orderPrice);
        moocOrder.setOrderStatus("0");
        moocOrder.setOrderTimestamp(new Date().getTime());
        moocOrder.setSeatsName(seatsName);
        Integer userId = moocOrderTMapper.getUserId(username);
        try {
            moocOrderTMapper.insertOrder(moocOrder, userId, filmPrice, cinemaId, filmId, fieldId, soldSeats);
        } catch (Exception e){
            e.printStackTrace();
            throw new GunsException(OrderException.ORDER_SYSTEM_ERROR);
        }
        OrderResponseVO<MoocOrder> moocOrderOrderResponseVO = new OrderResponseVO<>();
        moocOrderOrderResponseVO.ok(moocOrder);
        return moocOrderOrderResponseVO;
    }

    @Override
    public OrderResponseVO<List<MoocOrder>> getOrderInfo(int nowPage, int pageSize, String userName) throws GunsException{

        int offset = (nowPage - 1) * pageSize;

        List<MoocOrder> moocOrderList = moocOrderTMapper.selectMoocOrderByUser(userName, offset, pageSize);

        if (moocOrderList == null) {
            throw new GunsException(OrderException.GET_ORDER_ERROR);
        } else {

            OrderResponseVO<List<MoocOrder>> orderResponseVO = new OrderResponseVO<>();

            orderResponseVO.ok(moocOrderList);

            return orderResponseVO;

        }
    }

    @Override
    public Boolean isLegalSeat(String seat, String path) throws GunsException{

        String s = redis.get(path);
        if (s != null && s.length() != 0){
            String[] split = s.split(",");
            return Arrays.asList(split).contains(seat);
        }
        Seat seats = null;
        try {
            seats = JsonUtils.readJsonFromClassPath(path, Seat.class);
            String[] seatArray = seats.getIds().split(",");
            redis.set(path, seats.getIds());
            return Arrays.asList(seatArray).contains(seat);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GunsException(OrderException.ORDER_SYSTEM_ERROR);
        }
    }

    @Override
    public String soldSeats(Integer fieldId) throws GunsException {
        List<String> soldSeats = moocOrderTMapper.selectSoldSeats(fieldId);
        StringBuilder builder = new StringBuilder();
        for (String soldSeat : soldSeats) {
            builder.append(soldSeat);
            builder.append(",");
        }
        String sold = builder.toString();
        return sold.substring(0, sold.lastIndexOf(","));
    }
}
