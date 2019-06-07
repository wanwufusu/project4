package com.stylefeng.guns.film.common.exception;

import com.stylefeng.guns.core.exception.ServiceExceptionEnum;

public enum MyException implements ServiceExceptionEnum {

    USER_ERROR(1,"业务异常"),
    USER_SYSTEM(999, "系统异常");

    MyException(Integer status, String message) {
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
