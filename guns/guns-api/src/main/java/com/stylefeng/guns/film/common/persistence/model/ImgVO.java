package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/7
 * @since 1.0.0
 */
@Data
public class ImgVO implements Serializable {
    private String mainImg;
    private String img01;
    private String img02;
    private String img03;
    private String img04;
}
