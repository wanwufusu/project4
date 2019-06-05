package com.stylefeng.guns.gateway.modular.controller.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.film.common.persistence.model.FilmIndexVO;
import com.stylefeng.guns.film.common.persistence.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/5
 * @since 1.0.0
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Reference
    FilmService filmService;

    @RequestMapping("getIndex")
    public FilmIndexVO getIndex() throws GunsException {
        FilmIndexVO filmIndexVO = filmService.queryIndexInfo();
        return filmIndexVO;
    }
}
