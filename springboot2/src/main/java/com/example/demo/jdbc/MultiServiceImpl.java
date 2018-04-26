package com.example.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by ym on 2018/4/21.
 */
public class MultiServiceImpl implements MultiService {

    private UserService userService;

    public User get(String userId) {
        return userService.get(userId);
    };

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
