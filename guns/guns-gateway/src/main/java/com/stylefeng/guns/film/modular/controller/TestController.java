package com.stylefeng.guns.film.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.film.common.persistence.model.MtimeFilmT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testservice.MyTestService;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试用〉
 *
 * @author Ruimingz
 * @create 2019/6/4
 * @since 1.0.0
 */
@RestController
public class TestController {
    @Reference
    MyTestService myTestService;

    @RequestMapping("/testfilm")
    public MtimeFilmT mtimeFilmT(){
        return myTestService.selectFilmById(2);
    }
}
