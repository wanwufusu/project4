package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.Actor;
import com.stylefeng.guns.film.common.persistence.model.Director;
import com.stylefeng.guns.film.common.persistence.model.FilmDetailData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtimeFilmDetailMapper {
    FilmDetailData selectFilmDetailExceptInfo(@Param("filmId")String filmId,
                                              @Param("filmName")String filmName);

    String selectFilmCats(String id);

    Integer selectFilmSource(String id);

    Integer selectFilmLength(String id);

    String selectFilmShowTime(String id);

    String selectFilmBiography(String id);

    Director selectFilmDirector(String id);

    List<Actor> selectFilmActors(String id);

    String selectImgVO(String id);
}
