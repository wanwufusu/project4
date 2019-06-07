package com.stylefeng.guns.film.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.exception.FilmException;
import com.stylefeng.guns.film.common.exception.MyException;
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
    @Autowired
    MtimeFilmDetailMapper mtimeFilmDetailMapper;


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
    public FilmConditionResponseVO queryFilmConditions(Integer catId, Integer sourceId, Integer yearId) throws GunsException{

        if (catId < 0 || sourceId < 0 || yearId < 0) {
            throw new GunsException(FilmException.FILMCONDITION_ERROR);
        }
        try {
            //查询影片类型列表
            List<CatVo> catVos = new ArrayList<>();
            if (catId == 99) {
                catVos = mtimeCatDictTMapper.selectAllCats();
            } else {
                catVos.add(mtimeCatDictTMapper.selectCatById(catId));
            }
            //查询片源列表
            List<SourceVo> sourceVos = new ArrayList<>();
            if (sourceId == 99) {
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
        } catch (Exception e) {
            throw new GunsException(FilmException.INDEX_SYSTEM_ERROR);
        }
    }

    /**
     * 查询正在热映电影
     * @param filmRequestVO
     * @return
     * @throws GunsException
     */
    @Override
    public FilmQueryVO queryHotFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException {

        try {
            //先处理页面页数信息，查询总记录
            Integer totalNums = mtimeFilmTMapper.queryFilmsNumByConditions(filmRequestVO);
            int totalPage = totalNums / filmRequestVO.getNowPage() + 1;
            int offset = (filmRequestVO.getNowPage() - 1) * filmRequestVO.getPageSize();
            //查询热门信息
            List<Film> data = mtimeFilmTMapper.queryFilmsByConditions(filmRequestVO, offset);

            return FilmQueryVO.ok(filmRequestVO.getNowPage(), totalPage, data);
        }catch (Exception e) {
            e.printStackTrace();
            throw new GunsException(FilmException.INDEX_SYSTEM_ERROR);
        }
    }

    /**
     * 查询即将上映电影
     * @param filmRequestVO
     * @return
     * @throws GunsException
     */
    @Override
    public FilmQueryVO querySoonFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException {
        return queryHotFilmsByCondition(filmRequestVO);
    }

    /**
     * 查询经典电影
     * @param filmRequestVO
     * @return
     * @throws GunsException
     */
    @Override
    public FilmQueryVO queryClassicFilmsByCondition(FilmRequestVO filmRequestVO) throws GunsException {
        return queryHotFilmsByCondition(filmRequestVO);
    }

    @Override
    public FilmDetailVO queryFilmDetailsById(String filmId) throws GunsException {
        FilmDetailData filmDetailData;
        //首先查询filmName, filmEnName, imgAddress , score ,scoreNum , totalBox
        filmDetailData = mtimeFilmDetailMapper.selectFilmDetailExceptInfo(filmId, null);
        if (filmDetailData == null) {
            throw new GunsException(FilmException.FILMDETAIL_ERROR);
        }
        String id = filmDetailData.getFilmId();
        //获取电影的4列详细信息
        getFilmDetailsInfo(filmDetailData, id);
        return FilmDetailVO.ok(filmDetailData);
    }

    @Override
    public FilmDetailVO queryFilmDetailByName(String filmName) throws GunsException {
        FilmDetailData filmDetailData = new FilmDetailData();
        //首先查询filmName, filmEnName, imgAddress , score ,scoreNum , totalBox
        filmDetailData = mtimeFilmDetailMapper.selectFilmDetailExceptInfo(null, filmName);
        if (filmDetailData == null) {
            throw new GunsException(FilmException.FILMDETAIL_ERROR);
        }
        String id = filmDetailData.getFilmId();
        //获取电影的4列详细信息
        getFilmDetailsInfo(filmDetailData, id);
        return FilmDetailVO.ok(filmDetailData);
    }

    private void getFilmDetailsInfo(FilmDetailData filmDetailData, String id) {
        String info01 = getFilmCats(id);
        String info02 = getFilmSourceAndLength(id);
        String info03 = getFilmShowTime(id);
        FilmDetailInfo04 info04 = new FilmDetailInfo04();
        String biography = getFilmBiography(id);
        Actors actorsAndDirector = new Actors();
        Director director = getFilmDirector(id);
        List<Actor> actors = getFilmActors(id);
        ImgVO imgVO = getImgVO(id);

        String scoreNum = filmDetailData.getScoreNum();
        scoreNum += "万人评分";
        filmDetailData.setScoreNum(scoreNum);

        double totalBox = Double.valueOf(filmDetailData.getTotalBox()) / 10000;
        filmDetailData.setTotalBox(totalBox + "亿");

        filmDetailData.setInfo01(info01);
        filmDetailData.setInfo02(info02);
        filmDetailData.setInfo03(info03);
        info04.setBiography(biography);
        info04.setImgVO(imgVO);
        actorsAndDirector.setDirector(director);
        actorsAndDirector.setActors(actors);
        info04.setActors(actorsAndDirector);
        filmDetailData.setInfo04(info04);
    }

    private ImgVO getImgVO(String id) {
        String imgVOString = mtimeFilmDetailMapper.selectImgVO(id);
        String[] imgVOArray = imgVOString.split(",");
        ImgVO imgVO = new ImgVO();
        imgVO.setMainImg(imgVOArray[0]);
        imgVO.setImg01(imgVOArray[1]);
        imgVO.setImg02(imgVOArray[2]);
        imgVO.setImg03(imgVOArray[3]);
        imgVO.setImg04(imgVOArray[4]);
        return imgVO;
    }

    private List<Actor> getFilmActors(String id) {
        return mtimeFilmDetailMapper.selectFilmActors(id);
    }

    private Director getFilmDirector(String id) {
        return mtimeFilmDetailMapper.selectFilmDirector(id);
    }

    private String getFilmBiography(String id) {
        return mtimeFilmDetailMapper.selectFilmBiography(id);
    }

    private String getFilmShowTime(String id) {
        String showTime = mtimeFilmDetailMapper.selectFilmShowTime(id);
        String showTimeInfo = showTime.substring(0, 10) + "大陆上映";
        return showTimeInfo;
    }

    private String getFilmSourceAndLength(String id) {
        Integer sourceInt = mtimeFilmDetailMapper.selectFilmSource(id);
        SourceVo sourceVo = mtimeSourceDictTMapper.selectSourceById(sourceInt);
        Integer lengthInt = mtimeFilmDetailMapper.selectFilmLength(id);

        StringBuilder sourceAndLengthStash = new StringBuilder();
        sourceAndLengthStash.append(sourceVo.getSourceName());
        sourceAndLengthStash.append("/");
        sourceAndLengthStash.append(lengthInt);
        sourceAndLengthStash.append("分钟");
        return sourceAndLengthStash.toString();
    }

    private String getFilmCats(String id) {
        String catsStrings = mtimeFilmDetailMapper.selectFilmCats(id);
        String[] split = catsStrings.split("#");
        StringBuilder catsInfoStash = new StringBuilder();
        CatVo catVo = new CatVo();
        for (String s : split) {
            if (s != null && s.trim().length() > 0) {
                catVo = mtimeCatDictTMapper.selectCatById(Integer.parseInt(s));
                catsInfoStash.append(catVo.getCatName());
                catsInfoStash.append(", ");
            }
        }
        String catsInfo = catsInfoStash.toString();
        return catsInfo.substring(0, catsInfo.lastIndexOf(","));
    }
}
