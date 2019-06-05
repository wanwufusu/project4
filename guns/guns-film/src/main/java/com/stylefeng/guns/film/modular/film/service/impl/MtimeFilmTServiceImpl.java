package com.stylefeng.guns.film.modular.film.service.impl;

import com.stylefeng.guns.film.common.persistence.model.Film;
import com.stylefeng.guns.film.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.film.modular.film.service.IMtimeFilmTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 影片主表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@Service
public class MtimeFilmTServiceImpl extends ServiceImpl<MtimeFilmTMapper, Film> implements IMtimeFilmTService {

}
