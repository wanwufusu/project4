package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.cinema.common.persistence.model.MtimeBrandDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 品牌信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-05
 */
public interface MtimeBrandDictTMapper extends BaseMapper<MtimeBrandDictT> {

    List<MtimeBrandDictT> findById(@Param("brandId") Integer brandId);
}
