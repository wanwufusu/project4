package com.stylefeng.guns.cinema.common.persistence.dao;

import com.stylefeng.guns.cinema.common.persistence.model.MtimeHallFilmInfoT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影厅电影信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-05
 */
public interface MtimeHallFilmInfoTMapper extends BaseMapper<MtimeHallFilmInfoT> {

    List<MtimeHallFilmInfoT> findByCinemaId(@Param("cinemaId") String cinemaId);
}
