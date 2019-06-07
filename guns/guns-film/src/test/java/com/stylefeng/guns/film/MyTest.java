package com.stylefeng.guns.film;

import com.stylefeng.guns.film.common.persistence.model.FilmDetailVO;
import com.stylefeng.guns.film.common.persistence.service.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GunsFilmApplication.class)
@EnableAutoConfiguration
public class MyTest {

    @Autowired
    FilmService filmService;

    @Test
    public void test1(){
        FilmDetailVO filmDetailVO = filmService.queryFilmDetailsById("2");
//        filmDetailVO = filmService.queryFilmDetailByName("我不是药神");
        System.out.println(filmDetailVO);
    }
}
