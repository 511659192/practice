package com.spring.beans;

import com.spring.beans.factory.AbstractBeanFactory;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.PropertyValue;
import com.spring.beans.factory.config.RuntimeBeanReference;
import com.spring.beans.factory.config.ValueHolder;

/**
 * Created by ym on 2018/5/5.
 */
public class BeanDefinitionValueResolver {


    private final BeanFactory beanFactory;

    public BeanDefinitionValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(PropertyValue propertyValue, Object value) {
        if (value instanceof RuntimeBeanReference) {
            return resolveReference((RuntimeBeanReference) value);
        } else if (value instanceof ValueHolder) {
            return ((ValueHolder) value).getValue();
        }
        return null;
    }

    private Object resolveReference(RuntimeBeanReference value) {
        String beanName = value.getBeanName();
        Object bean = this.beanFactory.getBean(beanName);
        return bean;
    }
}
