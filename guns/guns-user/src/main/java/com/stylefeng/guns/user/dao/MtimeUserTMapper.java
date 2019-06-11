package com.stylefeng.guns.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.user.entity.MtimeUserT;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yutin
 * @since 2019-06-05
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    MtimeUserT validate(@Param("user") MtimeUserT user);

    MtimeUserT selectUserByName(@Param("name") String username);

    MtimeUserT selectUserById(@Param("id") int id);

    Integer updateUserById(@Param("user") MtimeUserT user);








}
