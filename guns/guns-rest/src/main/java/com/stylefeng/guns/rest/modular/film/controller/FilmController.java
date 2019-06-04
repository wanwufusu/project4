package com.stylefeng.guns.rest.modular.film.controller;

import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.service.IMtimeFilmTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈TestFilm〉
 *
 * @author Ruimingz
 * @create 2019/6/4
 * @since 1.0.0
 */
@RestController
public class FilmController {
    @Autowired
    IMtimeFilmTService iMtimeFilmTService;

    @RequestMapping("/test")
    public MtimeFilmT testMtimeFilmT(int id){
        return iMtimeFilmTService.selectById(id);
    }
}
