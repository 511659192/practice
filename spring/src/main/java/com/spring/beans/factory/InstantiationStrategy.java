package com.spring.beans.factory;

import com.spring.beans.factory.config.BeanDefinition;

/**
 * Created by ym on 2018/5/2.
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName);
}
