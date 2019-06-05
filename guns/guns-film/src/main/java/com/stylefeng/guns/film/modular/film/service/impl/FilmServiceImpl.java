package com.stylefeng.guns.film.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.film.common.persistence.dao.MtimeBannerTMapper;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.film.common.persistence.model.Banner;
import com.stylefeng.guns.film.common.persistence.model.FilmIndexVO;
import com.stylefeng.guns.film.common.persistence.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/5
 * @since 1.0.0
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService {

    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;


    @Override
    public FilmIndexVO queryIndexInfo() {
        List<Banner> banners = mtimeBannerTMapper.selectAllBanners();
        return FilmIndexVO.setIndexFilm(banners,0,null,0,null,null,
                null,null);
    }
}
