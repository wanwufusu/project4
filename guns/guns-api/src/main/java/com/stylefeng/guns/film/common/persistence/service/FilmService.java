package com.stylefeng.guns.film.common.persistence.service;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.persistence.model.FilmConditionResponseVO;
import com.stylefeng.guns.film.common.persistence.model.FilmIndexVO;
import com.stylefeng.guns.film.common.persistence.model.FilmQueryVO;
import com.stylefeng.guns.film.common.persistence.model.FilmRequestVO;

public interface FilmService {
    FilmIndexVO queryIndexInfo() throws GunsException;

    FilmConditionResponseVO queryFilmConditions(Integer catId, Integer sourceId, Integer yearId) throws GunsException;

    FilmQueryVO queryHotFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException;

    FilmQueryVO querySoonFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException;

    FilmQueryVO queryClassicFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException;
}
