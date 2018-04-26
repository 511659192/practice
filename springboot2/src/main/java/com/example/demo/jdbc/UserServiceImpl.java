package com.example.demo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by ym on 2018/4/21.
 */
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User get(String userId) {
        User user = jdbcTemplate.queryForObject("select * from t_user where user_id = ?", new Object[]{userId}, new UserRowMapper());
//        throw new RuntimeException("test rollback");
        jdbcTemplate.update("update t_user set user_name = 'bbbb' where user_id = ?", new Object[]{userId});
        return user;
    }

    @Override
    public User get2(String userId) {
        User user = jdbcTemplate.queryForObject("select * from t_user where user_id = ?", new Object[]{userId}, new UserRowMapper());
        return user;
    }

    ;
}
