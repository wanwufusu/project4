package com.stylefeng.guns.core.base.tips;

/**
 * 〈一句话功能简述〉<br>
 * 〈Error Message〉
 *
 * @author Ruimingz
 * @create 2019/6/5
 * @since 1.0.0
 */

public class MyErrorTip {
    private int status;
    private String msg;

    public MyErrorTip(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
