package com.stylefeng.guns.film.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.film.common.persistence.model.SourceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 区域信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-06
 */
public interface MtimeSourceDictTMapper extends BaseMapper<SourceVo> {
    List<SourceVo> selectAllSources();
    SourceVo selectSourceById(@Param("sourceId")Integer id);
}
