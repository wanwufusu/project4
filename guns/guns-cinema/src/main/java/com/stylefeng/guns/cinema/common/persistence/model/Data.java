package com.stylefeng.guns.cinema.common.persistence.model;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
    MtimeCinemaT cinemaInfo;
    List<MtimeHallFilmInfoT> filmList;
    MtimeHallDictT hallInfo;
    MtimeHallFilmInfoT filmInfo;
    List<MtimeCinemaT> data;
    List<MtimeBrandDictT> brandList;
    List<MtimeAreaDictT> areaList;
    List<MtimeHallDictT> halltypeList;

    public List<MtimeBrandDictT> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<MtimeBrandDictT> brandList) {
        this.brandList = brandList;
    }

    public List<MtimeAreaDictT> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<MtimeAreaDictT> areaList) {
        this.areaList = areaList;
    }

    public List<MtimeHallDictT> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<MtimeHallDictT> halltypeList) {
        this.halltypeList = halltypeList;
    }

    public List<MtimeCinemaT> getData() {
        return data;
    }

    public void setData(List<MtimeCinemaT> data) {
        this.data = data;
    }

    public MtimeHallFilmInfoT getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(MtimeHallFilmInfoT filmInfo) {
        this.filmInfo = filmInfo;
    }

    public MtimeHallDictT getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(MtimeHallDictT hallInfo) {
        this.hallInfo = hallInfo;
    }

    public MtimeCinemaT getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(MtimeCinemaT cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<MtimeHallFilmInfoT> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<MtimeHallFilmInfoT> filmList) {
        this.filmList = filmList;
    }
}
