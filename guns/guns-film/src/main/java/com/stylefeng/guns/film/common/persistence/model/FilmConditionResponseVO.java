package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class FilmConditionResponseVO implements Serializable {

    private Integer status;

    private FilmConditionVO data;

    /**
     * 返回一个响应成功的影片条件查询报文
     * @param catVos
     * @param sourceVos
     * @param yearVos
     * @return
     */
    public static FilmConditionResponseVO ok(List<CatVo> catVos, List<SourceVo> sourceVos, List<YearVo> yearVos){
        FilmConditionVO filmConditionVO = new FilmConditionVO();
        filmConditionVO.setCatInfo(catVos);
        filmConditionVO.setSourceInfo(sourceVos);
        filmConditionVO.setYearInfo(yearVos);
        FilmConditionResponseVO filmConditionResponseVO = new FilmConditionResponseVO();
        filmConditionResponseVO.setStatus(0);
        filmConditionResponseVO.setData(filmConditionVO);
        return filmConditionResponseVO;
    }
}
