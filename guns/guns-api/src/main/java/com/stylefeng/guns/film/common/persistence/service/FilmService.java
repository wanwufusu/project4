package com.stylefeng.guns.film.common.persistence.service;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.persistence.model.FilmConditionResponseVO;
import com.stylefeng.guns.film.common.persistence.model.FilmIndexVO;

public interface FilmService {
    FilmIndexVO queryIndexInfo() throws GunsException;

    FilmConditionResponseVO queryFilmConditions(Integer catId, Integer sourceId, Integer yearId);
}
