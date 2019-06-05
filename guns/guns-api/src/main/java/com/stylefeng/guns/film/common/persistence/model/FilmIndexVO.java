package com.stylefeng.guns.film.common.persistence.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈首页数据VO〉
 *
 * @author Ruimingz
 * @create 2019/6/4
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmIndexVO implements Serializable {
    /**
     * 主页影片状态
     */
    private int status;
    /**
     * 主页显示图片
     */
    private String imgPre = "http://img.meetingshop.cn/";
    /**
     * 主页具体数据
     */
    private Data data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /**
     * 主页具体电影信息
     * @param banners
     * @param hotFilmsNum
     * @param hotfilms
     * @param soonFilmsNum
     * @param soonFilms
     * @param boxRanking
     * @param expectRanking
     * @param top100
     * @return
     */
    public static FilmIndexVO setIndexFilm(List<Banner> banners, int hotFilmsNum, List<Film> hotfilms,
                                           int soonFilmsNum, List<Film> soonFilms, List<Film> boxRanking,
                                           List<Film> expectRanking, List<Film> top100){
        FilmIndexVO filmIndexVO = new FilmIndexVO();
        Data data = new Data();
        data.hotFilms = new FilmWithNum();
        data.soonFilms = new FilmWithNum();
        data.banners = banners;
        data.hotFilms.filmNum = hotFilmsNum;
        data.hotFilms.filmInfo = hotfilms;
        data.soonFilms.filmNum = soonFilmsNum;
        data.soonFilms.filmInfo = soonFilms;
        data.boxRanking = boxRanking;
        data.expectRanking = expectRanking;
        data.top100 = top100;
        filmIndexVO.setData(data);
        filmIndexVO.setStatus(0);
        return filmIndexVO;
    }

    @Override
    public String toString() {
        return "FilmIndexVO{" +
                "status=" + status +
                ", imgPre='" + imgPre + '\'' +
                ", data=" + data +
                '}';
    }

    private static class Data implements Serializable{
        List<Banner> banners;
        FilmWithNum hotFilms;
        FilmWithNum soonFilms;
        List<Film> boxRanking;
        List<Film> expectRanking;
        List<Film> top100;

        public List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(List<Banner> banners) {
            this.banners = banners;
        }

        public FilmWithNum getHotFilms() {
            return hotFilms;
        }

        public void setHotFilms(FilmWithNum hotFilms) {
            this.hotFilms = hotFilms;
        }

        public FilmWithNum getSoonFilms() {
            return soonFilms;
        }

        public void setSoonFilms(FilmWithNum soonFilms) {
            this.soonFilms = soonFilms;
        }

        public List<Film> getBoxRanking() {
            return boxRanking;
        }

        public void setBoxRanking(List<Film> boxRanking) {
            this.boxRanking = boxRanking;
        }

        public List<Film> getExpectRanking() {
            return expectRanking;
        }

        public void setExpectRanking(List<Film> expectRanking) {
            this.expectRanking = expectRanking;
        }

        public List<Film> getTop100() {
            return top100;
        }

        public void setTop100(List<Film> top100) {
            this.top100 = top100;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "banners=" + banners +
                    ", hotFilms=" + hotFilms +
                    ", soonFilms=" + soonFilms +
                    ", boxRanking=" + boxRanking +
                    ", expectRanking=" + expectRanking +
                    ", top100=" + top100 +
                    '}';
        }
    }
    private static class FilmWithNum implements Serializable{
        private int filmNum;
        private List<Film> filmInfo;

        public int getFilmNum() {
            return filmNum;
        }

        public void setFilmNum(int filmNum) {
            this.filmNum = filmNum;
        }

        public List<Film> getFilmInfo() {
            return filmInfo;
        }

        public void setFilmInfo(List<Film> filmInfo) {
            this.filmInfo = filmInfo;
        }

        @Override
        public String toString() {
            return "FilmWithNum{" +
                    "filmNum=" + filmNum +
                    ", filmInfo=" + filmInfo +
                    '}';
        }
    }
}
