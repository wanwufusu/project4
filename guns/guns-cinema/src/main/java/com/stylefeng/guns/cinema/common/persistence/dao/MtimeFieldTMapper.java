package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.cinema.common.persistence.model.Data;
import com.stylefeng.guns.cinema.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.cinema.common.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-05
 */
public interface MtimeFieldTMapper extends BaseMapper<MtimeFieldT> {

    Data findByCinemaIdAndFieldId(@Param("cinemaId") String cinemaId, @Param("fieldId") String fieldId);
}
