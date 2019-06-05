package com.stylefeng.guns.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>
 * banner信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer bannerId;
    /**
     * banner图存放路径
     */
    private String bannerAddress;
    /**
     * banner点击跳转url
     */
    private String bannerUrl;
    /**
     * 是否弃用 0-失效,1-失效
     */
    private Integer isValid;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId=" + bannerId +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
