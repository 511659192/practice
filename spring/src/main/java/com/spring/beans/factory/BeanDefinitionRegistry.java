package com.spring.beans.factory;

import com.spring.beans.factory.AliasRegistry;
import com.spring.beans.factory.config.BeanDefinition;

/**
 * Created by ym on 2018/4/28.
 */
public interface BeanDefinitionRegistry extends AliasRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
