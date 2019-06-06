/*
package com.stylefeng.guns.film.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.film.common.persistence.dao.MtimeCatDictTMapper;
import com.stylefeng.guns.film.common.persistence.dao.MtimeSourceDictTMapper;
import com.stylefeng.guns.film.common.persistence.dao.MtimeYearDictTMapper;
import com.stylefeng.guns.film.common.persistence.model.CatVo;
import com.stylefeng.guns.film.common.persistence.model.FilmConditionResponseVO;
import com.stylefeng.guns.film.common.persistence.model.SourceVo;
import com.stylefeng.guns.film.common.persistence.model.YearVo;
import com.stylefeng.guns.film.common.persistence.service.FilmConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 *//*

@Component
@Service(interfaceClass = FilmConditionService.class)
public class FilmConditionServiceImpl implements FilmConditionService {

    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;

    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;

    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;

    */
/**
     * 查询影片条件的具体实现
     * @param catId
     * @param sourceId
     * @param yearId
     * @return
     *//*

    @Override
    public FilmConditionResponseVO queryFilmConditions(Integer catId, Integer sourceId, Integer yearId) {
        //查询影片类型列表
        List<CatVo> catVos = new ArrayList<>();
        if (catId == 99){
            catVos = mtimeCatDictTMapper.selectList(null);
        } else {
            catVos.add(mtimeCatDictTMapper.selectById(catId));
        }
        //查询片源列表
        List<SourceVo> sourceVos = new ArrayList<>();
        if (sourceId == 99){
            sourceVos = mtimeSourceDictTMapper.selectList(null);
        } else {
            sourceVos.add(mtimeSourceDictTMapper.selectById(sourceId));
        }
        //查询年代列表
        List<YearVo> yearVos = new ArrayList<>();
        if (yearId == 99) {
            yearVos = mtimeYearDictTMapper.selectList(null);
        } else {
            yearVos.add(mtimeYearDictTMapper.selectById(yearId));
        }

        FilmConditionResponseVO filmConditionResponseVO = FilmConditionResponseVO.ok(catVos, sourceVos, yearVos);
        return filmConditionResponseVO;
    }
}
*/
