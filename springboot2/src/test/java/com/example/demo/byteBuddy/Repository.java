package com.example.demo.byteBuddy;

/**
 * Created by ym on 2018/4/1.
 */
public abstract class Repository<T> {
    abstract T findOne(int id);
}
