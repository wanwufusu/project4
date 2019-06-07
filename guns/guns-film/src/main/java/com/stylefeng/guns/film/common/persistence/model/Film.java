package com.stylefeng.guns.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>
 * 影片主表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Film implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer filmId;
    /**
     * 影片名称
     */
    private String filmName;
    /**
     * 片源类型: 0-2D,1-3D,2-3DIMAX,4-无
     */
    private String filmType;
    /**
     * 影片主图地址
     */
    private String imgAddress;
    /**
     * 影片评分
     */
    private String filmScore;
    /**
     * 影片预售数量
     */
    private Integer filmPresalenum;
    /**
     * 影片票房：每日更新，以万为单位
     */
    private Integer boxNum;
    /**
     * 影片片源，参照片源字典表
     */
    private Integer filmSource;
    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    private String filmCats;
    /**
     * 影片区域，参照区域表
     */
    private Integer filmArea;
    /**
     * 影片上映年代，参照年代表
     */
    private Integer filmDate;
    /**
     * 影片上映时间
     */
    private Date showTime;
    /**
     * 影片状态,1-正在热映，2-即将上映，3-经典影片
     */
    private Integer filmStatus;
    /**
     * 影片期待值，反映观众对该影片的期望
     */
    private Integer expectNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public Integer getFilmPresalenum() {
        return filmPresalenum;
    }

    public void setFilmPresalenum(Integer filmPresalenum) {
        this.filmPresalenum = filmPresalenum;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(Integer filmSource) {
        this.filmSource = filmSource;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public Integer getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(Integer filmArea) {
        this.filmArea = filmArea;
    }

    public Integer getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(Integer filmDate) {
        this.filmDate = filmDate;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    public Integer getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(Integer expectNum) {
        this.expectNum = expectNum;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmType=" + filmType +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmScore='" + filmScore + '\'' +
                ", filmPresalenum=" + filmPresalenum +
                ", boxNum=" + boxNum +
                ", filmSource=" + filmSource +
                ", filmCats='" + filmCats + '\'' +
                ", filmArea=" + filmArea +
                ", filmDate=" + filmDate +
                ", showTime=" + showTime +
                ", filmStatus=" + filmStatus +
                ", expectNum=" + expectNum +
                '}';
    }
}
