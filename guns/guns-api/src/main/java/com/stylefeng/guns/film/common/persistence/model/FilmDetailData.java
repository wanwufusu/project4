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
public class FilmDetailData implements Serializable {
    private String filmName;
    private String filmEnName;
    private String imgAddress;
    private String score;
    private String scoreNum;
    private String totalBox;
    private String info01;
    private String info02;
    private String info03;
    private FilmDetailInfo04 info04;
    private String filmId;
}
