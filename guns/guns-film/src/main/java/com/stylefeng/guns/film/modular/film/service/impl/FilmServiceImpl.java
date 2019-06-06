package com.stylefeng.guns.film.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.exception.FilmException;
import com.stylefeng.guns.film.common.persistence.dao.*;
import com.stylefeng.guns.film.common.persistence.model.*;

import com.stylefeng.guns.film.common.persistence.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/5
 * @since 1.0.0
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService {

    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;
    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;
    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;
    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;


    /**
     * 查找首页电影信息
     * @return
     */
    @Override
    public FilmIndexVO queryIndexInfo() throws GunsException{
        try {
            List<Banner> banners = mtimeBannerTMapper.selectAllBanners();
            Integer queryHotFilmsNum = mtimeFilmTMapper.queryHotFilmsNum();
            List<Film> queryHotFilms = mtimeFilmTMapper.queryHotFilms();
            Integer querySoonFilmsNum = mtimeFilmTMapper.querySoonFilmsNum();
            List<Film> querySoonFilms = mtimeFilmTMapper.querySoonFilms();
            int i = 1/0;
            List<Film> queryBoxRanking = mtimeFilmTMapper.queryBoxRanking();
            List<Film> queryExpectRanking = mtimeFilmTMapper.queryExpectRanking();
            List<Film> queryTop100 = mtimeFilmTMapper.queryTop100();
            return FilmIndexVO.setIndexFilm(banners,
                    queryHotFilmsNum, queryHotFilms,
                    querySoonFilmsNum, querySoonFilms,
                    queryBoxRanking,
                    queryExpectRanking,
                    queryTop100);
        } catch (Exception e) {
            throw new GunsException(FilmException.INDEX_SYSTEM_ERROR);
        }
    }


    /**
     * 查询影片条件的具体实现
     * @param catId
     * @param sourceId
     * @param yearId
     * @return
     */
    @Override
    public FilmConditionResponseVO queryFilmConditions(Integer catId, Integer sourceId, Integer yearId) {
        //查询影片类型列表
        List<CatVo> catVos = new ArrayList<>();
        if (catId == 99){
            catVos = mtimeCatDictTMapper.selectAllCats();
        } else {
            catVos.add(mtimeCatDictTMapper.selectCatById(catId));
        }
        //查询片源列表
        List<SourceVo> sourceVos = new ArrayList<>();
        if (sourceId == 99){
            sourceVos = mtimeSourceDictTMapper.selectAllSources();
        } else {
            sourceVos.add(mtimeSourceDictTMapper.selectSourceById(sourceId));
        }
        //查询年代列表
        List<YearVo> yearVos = new ArrayList<>();
        if (yearId == 99) {
            yearVos = mtimeYearDictTMapper.selectAllYears();
        } else {
            yearVos.add(mtimeYearDictTMapper.selectYearById(yearId));
        }

        FilmConditionResponseVO filmConditionResponseVO = FilmConditionResponseVO.ok(catVos, sourceVos, yearVos);
        return filmConditionResponseVO;
    }
}
