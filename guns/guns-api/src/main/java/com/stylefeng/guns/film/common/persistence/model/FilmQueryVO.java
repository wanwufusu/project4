package com.stylefeng.guns.film.common.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈影片查询实体〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class FilmQueryVO implements Serializable {
    private Integer status;
    private String imgPre = "http://img.meetingshop.cn/";
    private Integer nowPage;
    private Integer totalPage;
    private List<Film> data;

    public static FilmQueryVO ok(Integer nowPage, Integer totalPage, List<Film> films){
        FilmQueryVO filmQueryVO = new FilmQueryVO();
        filmQueryVO.setNowPage(nowPage);
        filmQueryVO.setTotalPage(totalPage);
        filmQueryVO.setData(films);
        filmQueryVO.setStatus(0);
        return filmQueryVO;

    }
}
