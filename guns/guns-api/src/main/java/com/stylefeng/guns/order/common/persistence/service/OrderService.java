package com.stylefeng.guns.order.common.persistence.service;

import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.OrderResponseVO;

import java.util.List;

public interface OrderService {

    //todo
    //OrderResponseVO<MoocOrder> buyTickets();

    OrderResponseVO<List<MoocOrder>> getOrderInfo(int nowPage, int pageSize, String userName);
}
