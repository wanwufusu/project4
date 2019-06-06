package com.stylefeng.guns.film.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.film.common.persistence.model.YearVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 年代信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-06
 */
public interface MtimeYearDictTMapper extends BaseMapper<YearVo> {
    List<YearVo> selectAllYears();
    YearVo selectYearById(@Param("yearId")Integer id);
}
