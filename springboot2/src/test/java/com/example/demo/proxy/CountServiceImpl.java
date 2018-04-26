package com.example.demo.proxy;

/**
 * Created by ym on 2018/4/1.
 */
public class CountServiceImpl implements CountService {

    private int count = 1000;

    public int count() {
        return count ++;
    }
}
