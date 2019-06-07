package com.stylefeng.guns.user.common.exception;

import com.stylefeng.guns.core.exception.ServiceExceptionEnum;

public enum  UserExceptionEnum  implements ServiceExceptionEnum {

    USER_SYSTEM_ERROR(999, "系统出现异常，请联系管理员"),

    USERNAME_PASSWORD_ERROR(1,"账户名或密码错误"),

    USER_OCCUPIED_ERROR(1, "用户已存在"),

    LOGOUT_FAIL(1,"退出失败，用户尚未登陆"),

    USER_INFO_QUERY_ERROR(1,"查询失败，用户尚未登陆"),

    USER_INFO_UPDATE_ERROR(1,"用户信息修改失败");


    private Integer code;

    private String message;

    UserExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
