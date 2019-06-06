package com.stylefeng.guns.film.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.film.common.persistence.model.CatVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 类型信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-06
 */
public interface MtimeCatDictTMapper extends BaseMapper<CatVo> {
    List<CatVo> selectAllCats();
    CatVo selectCatById(@Param("catId") Integer id);
}
