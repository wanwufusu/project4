package com.stylefeng.guns.order.common.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/11
 * @since 1.0.0
 */
@Data
public class OrderResponseVO<T> implements Serializable {

    private int status;

    private String msg;

    private T moocOrder;

    public void ok(T moocOrder){
        this.status = 0;
        this.msg = "";
        this.moocOrder = moocOrder;
    }

}
