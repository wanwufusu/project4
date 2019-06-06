package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈影片条件列表〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class FilmConditionVO implements Serializable {

    //类型列表
    private List<CatVo> catInfo;
    //片源列表
    private List<SourceVo> sourceInfo;
    //年份列表
    private List<YearVo> yearInfo;
}
