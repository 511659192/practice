package com.example.demo.mock;

/**
 * Created by ym on 2018/4/1.
 */
public interface Entity<T> {

    T getObject();

    <E> E getA();
}
