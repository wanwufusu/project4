package com.stylefeng.guns.order.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/12
 * @since 1.0.0
 */

public class LongToDateHandler extends BaseTypeHandler<Long> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {
        Date date = new Date(aLong);
        preparedStatement.setDate(i, date);
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Long getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
