package com.example.demo.jdbc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ym on 2018/4/21.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface UserService {

    public User get(String userId);

    public User get2(String userId);
}
