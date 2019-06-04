package com.stylefeng.guns.film.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.film.common.persistence.model.MtimeFilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testservice.MyTestService;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/4
 * @since 1.0.0
 */
@Service(interfaceClass = MyTestService.class)
@Component
public class MyTestServiceImpl implements MyTestService{
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;

    @Override
    public MtimeFilmT selectFilmById(int id) {
        return mtimeFilmTMapper.selectById(id);
    }
}
