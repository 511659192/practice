package com.example.demo.jdbc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ym on 2018/4/21.
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface MultiService {

    public User get(String userId);
}
