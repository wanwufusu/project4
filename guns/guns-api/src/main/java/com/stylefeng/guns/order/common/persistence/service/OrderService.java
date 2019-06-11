package com.stylefeng.guns.order.common.persistence.service;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;

import java.util.List;

public interface OrderService {

    OrderResponseVO<MoocOrder> buyTickets(int fieldId, String soldSeats, String seatsName, String username);

    OrderResponseVO<List<MoocOrder>> getOrderInfo(int nowPage, int pageSize, String userName) throws GunsException;

    Boolean isLegalSeat(String seat, String path) throws GunsException;

    String soldSeats(Integer fieldId) throws GunsException;
}
