package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class FilmRequestVO implements Serializable {
    private Integer showType = 1;
    private Integer sortId = 1;
    private Integer catId = 99;
    private Integer sourceId = 99;
    private Integer yearId = 99;
    private Integer nowPage = 1;
    private Integer pageSize = 18;
}
