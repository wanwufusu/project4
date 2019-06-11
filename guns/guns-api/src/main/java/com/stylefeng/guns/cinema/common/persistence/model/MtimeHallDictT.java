package com.stylefeng.guns.cinema.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 地域信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-05
 */
@TableName("mtime_hall_dict_t")
public class MtimeHallDictT extends Model<MtimeHallDictT> {

    private static final long serialVersionUID = 1L;
    private Boolean isActive = false;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer hallTypeId;

    private String seatFile;

    private String hallName;

    private Integer price;

    private String soldSeats;

    private Integer hallFieldId;
    /**
     * 显示名称
     */
    @TableField("show_name")
    private String hallTypeName;
    /**
     * 座位文件存放地址
     */
    @TableField("seat_address")
    private String seatAddress;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getHallTypeId() {
        return hallTypeId;
    }

    public void setHallTypeId(Integer hallTypeId) {
        this.hallTypeId = hallTypeId;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    public Integer getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(Integer hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallTypeName() {
        return hallTypeName;
    }

    public void setHallTypeName(String hallTypeName) {
        this.hallTypeName = hallTypeName;
    }

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    @Override
    protected Serializable pkVal() {
        return this.hallFieldId;
    }

}
