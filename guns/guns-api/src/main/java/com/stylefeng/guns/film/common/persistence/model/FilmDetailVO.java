package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈影片详情VO〉
 *
 * @author Ruimingz
 * @create 2019/6/7
 * @since 1.0.0
 */
@Data
public class FilmDetailVO implements Serializable {
    private Integer status;
    private String imgPre = "http://img.meetingshop.cn/";
    private FilmDetailData data;

    public static FilmDetailVO ok(FilmDetailData filmDetailData){
        FilmDetailVO filmDetailVO = new FilmDetailVO();
        filmDetailVO.setData(filmDetailData);
        filmDetailVO.setStatus(0);
        return filmDetailVO;
    }
}
