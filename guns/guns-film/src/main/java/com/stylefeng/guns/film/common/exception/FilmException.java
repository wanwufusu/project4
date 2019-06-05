package com.stylefeng.guns.film.common.exception;

import com.stylefeng.guns.core.exception.ServiceExceptionEnum;

public enum FilmException implements ServiceExceptionEnum {

    /**
     * 影片首页系统异常
     */
    INDEX_SYSTEM_ERROR(999, "系统出现异常，请联系管理员");

    FilmException(Integer code, String message) {
        this.code = code;
        Message = message;
    }

    private Integer code;

    private String Message;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return Message;
    }
}
