package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.cinema.common.persistence.model.MtimeBrandDictT;
import com.stylefeng.guns.cinema.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-05
 */
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {

    List<MtimeHallDictT> findById(@Param("halltypeId") Integer hallType);
}
