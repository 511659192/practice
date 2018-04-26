package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ym on 2018/2/28.
 */
public class TestB {

    @Autowired
    TestC testC;

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
