package com.spring.beans.factory;

/**
 * Created by ym on 2018/4/30.
 */
public interface ObjectFactory<T> {

    T getObject() throws RuntimeException;
}
