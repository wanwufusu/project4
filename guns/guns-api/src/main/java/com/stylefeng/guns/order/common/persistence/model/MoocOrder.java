package com.stylefeng.guns.order.common.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户影片订单信息〉
 *
 * @author Ruimingz
 * @create 2019/6/11
 * @since 1.0.0
 */
@Data
public class MoocOrder implements Serializable {

    private String orderId;

    private String filmName;

    private String fieldTime;

    private String cinemaName;

    private String seatsName;

    private Double orderPrice;

    private Long orderTimestamp;

    private String orderStatus;
}
