package com.example.demo.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ym on 2018/4/21.
 */
public class UserRowMapper implements RowMapper<User> {
    @Nullable
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setUserBirthday(rs.getString("user_birthday"));
        user.setUserSalary(rs.getBigDecimal("user_salary"));
        return user;
    }
}
