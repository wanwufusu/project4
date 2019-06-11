package com.stylefeng.guns.order.common.persistence.model;

import lombok.Data;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/11
 * @since 1.0.0
 */
@Data
public class Seat implements Serializable {
    private int limit;

    private String ids;

    private List<List<UnitSeat>> single;

    private List<List<UnitSeat>> couple;

    @Data
    class UnitSeat implements Serializable{
        private Integer seatId;

        private Integer row;

        private Integer column;
    }
}
