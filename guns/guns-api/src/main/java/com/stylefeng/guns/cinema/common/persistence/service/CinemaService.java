package com.stylefeng.guns.cinema.common.persistence.service;

import com.stylefeng.guns.cinema.common.persistence.model.ResponseVo;

public interface CinemaService {
    ResponseVo getFiled(String cinemaId);
    ResponseVo getFiledInfo(String cinemaId, String fieldId);
}
