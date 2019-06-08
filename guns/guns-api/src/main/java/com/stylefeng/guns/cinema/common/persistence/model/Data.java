package com.stylefeng.guns.cinema.common.persistence.model;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
    MtimeCinemaT cinemaInfo;
    List<MtimeHallFilmInfoT> filmList;
    MtimeHallDictT hallInfo;
    MtimeHallFilmInfoT filmInfo;

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
