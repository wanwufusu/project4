package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.film.common.persistence.model.Banner;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
public interface MtimeBannerTMapper extends BaseMapper<Banner> {
    List<Banner> selectAllBanners();
}
