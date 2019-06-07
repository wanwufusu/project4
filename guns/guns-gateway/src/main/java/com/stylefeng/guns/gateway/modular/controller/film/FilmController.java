package com.stylefeng.guns.gateway.modular.controller.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.persistence.model.*;
import com.stylefeng.guns.film.common.persistence.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/5
 * @since 1.0.0
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Reference(check = false)
    FilmService filmService;


    @RequestMapping("getIndex")
    public FilmIndexVO getIndex() throws GunsException {
        FilmIndexVO filmIndexVO = filmService.queryIndexInfo();
        return filmIndexVO;
    }

    @RequestMapping("getConditionList")
    public FilmConditionResponseVO getConditionList(@RequestParam(defaultValue = "99")Integer catId,
                                                    @RequestParam(defaultValue = "99")Integer sourceId,
                                                    @RequestParam(defaultValue = "99")Integer yearId) throws GunsException {
        FilmConditionResponseVO filmConditionResponseVO = filmService.queryFilmConditions(catId, sourceId, yearId);
        return filmConditionResponseVO;
    }

    @RequestMapping("getFilms")
    public FilmQueryVO getFilms(FilmRequestVO filmRequestVO){
        Integer showType = filmRequestVO.getShowType();
        if (showType == 1) {
            return filmService.queryHotFilmsByCondition(filmRequestVO);
        } else if (showType == 2) {
            return filmService.querySoonFilmsByCondition(filmRequestVO);
        } else {
            return filmService.queryClassicFilmsByCondition(filmRequestVO);
        }
    }

}
