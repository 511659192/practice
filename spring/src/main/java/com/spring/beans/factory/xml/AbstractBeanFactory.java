package com.spring.beans.factory.xml;

import com.spring.beans.factory.config.BeanDefinition;

/**
 * Created by ym on 2018/5/2.
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    public <T> T getBean(String name) throws RuntimeException {
        final String beanName = getAliasIfExist(name);
        Object instance = getSingleton(beanName);
        if (instance != null) {
            return (T) instance;
        }

        final BeanDefinition beanDefinition = getBeanDefinition(beanName);
        instance = getSingleton(beanName, new ObjectFactory<Object>() {
            @Override
            public Object getObject() throws RuntimeException {
                return createBean(beanName, beanDefinition);
            }
        });
        return (T) instance;
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
