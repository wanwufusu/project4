package com.stylefeng.guns.cinema.common.persistence.model;

import java.io.Serializable;

public class RequestVo implements Serializable {
    Integer brandId = 99;
    Integer hallType = 99;
    Integer districtId = 99;
    Integer pageSize = 12;
    Integer nowPage = 1;
    Integer areaId = 99;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getHallType() {
        return hallType;
    }

    public void setHallType(Integer hallType) {
        this.hallType = hallType;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "RequestVo{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", districtId=" + districtId +
                ", pageSize=" + pageSize +
                ", nowPage=" + nowPage +
                ", areaId=" + areaId +
                '}';
    }
}
