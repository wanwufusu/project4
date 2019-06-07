package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.Banner;
import com.stylefeng.guns.film.common.persistence.model.Film;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.film.common.persistence.model.FilmRequestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
public interface MtimeFilmTMapper extends BaseMapper<Film> {

    Integer queryHotFilmsNum();

    List<Film> queryHotFilms();

    Integer querySoonFilmsNum();

    List<Film> querySoonFilms();

    List<Film> queryBoxRanking();

    List<Film> queryExpectRanking();

    List<Film> queryTop100();

    List<Film> querySoonFilmsByConditions();

    List<Film> queryClassicFilmsByConditions();

    List<Film> queryFilmsByConditions(@Param("conditions")FilmRequestVO filmRequestVO, @Param("offset")Integer offset);

    Integer queryFilmsNumByConditions(@Param("conditions")FilmRequestVO filmRequestVO);

}
