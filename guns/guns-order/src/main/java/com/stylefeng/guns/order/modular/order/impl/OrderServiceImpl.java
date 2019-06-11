package com.stylefeng.guns.order.modular.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.order.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;
import com.stylefeng.guns.order.common.persistence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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


    @Override
    public OrderResponseVO<List<MoocOrder>> getOrderInfo(int nowPage, int pageSize, String userName) {

        int offset = (nowPage - 1) * pageSize;

        List<MoocOrder> moocOrderList = moocOrderTMapper.selectMoocOrderByUser(userName, offset, pageSize);

        if (moocOrderList == null) {
            //todo
            return null;
        } else {

            OrderResponseVO<List<MoocOrder>> orderResponseVO = new OrderResponseVO<>();

            orderResponseVO.ok(moocOrderList);

            return orderResponseVO;

        }
    }
}
