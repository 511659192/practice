package com.spring.beans.factory.xml;

/**
 * Created by ym on 2018/5/2.
 */
public interface BeanFactory {

    <T> T getBean(String name) throws RuntimeException;
}
