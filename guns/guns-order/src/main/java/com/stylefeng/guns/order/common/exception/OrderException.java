package com.stylefeng.guns.order.common.exception;

import com.stylefeng.guns.core.exception.ServiceExceptionEnum;

public enum OrderException implements ServiceExceptionEnum {

    /**
     * 下单业务异常
     */
    POST_ORDER_ERROR(1,"该订单不存在"),
    /**
     * 获取订单信息业务异常
     */
    GET_ORDER_ERROR(1, "订单列表为空哦！~"),
    /**
     * 系统异常
     */
    ORDER_SYSTEM_ERROR(999, "系统异常");

    OrderException(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private Integer status;

    private String message;

    @Override
    public Integer getCode() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
