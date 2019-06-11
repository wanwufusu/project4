package com.stylefeng.guns.order.common.persistence.dao;

import com.stylefeng.guns.order.common.persistence.model.MoocOrder;
import com.stylefeng.guns.order.common.persistence.model.MoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-11
 */
public interface MoocOrderTMapper extends BaseMapper<MoocOrder> {

    List<MoocOrder> selectMoocOrderByUser(@Param("username")String userName,
                                          @Param("offset")int offset,
                                          @Param("pageSize")int pageSize);

    List<String> selectSoldSeats(Integer fieldId);
}
