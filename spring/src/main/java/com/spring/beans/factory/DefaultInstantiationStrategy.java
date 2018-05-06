package com.spring.beans.factory;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Created by ym on 2018/5/2.
 */
public class DefaultInstantiationStrategy implements InstantiationStrategy {

    public Object instantiate(BeanDefinition beanDefinition, String beanName) {
        if (beanDefinition.hasMethodOverrides()) {
            return instantiateWithMethodInjection(beanDefinition, beanName);
        }

        Constructor<?> constructorToUse;
        synchronized (beanDefinition.constructorArgumentLock) {
            constructorToUse = beanDefinition.getResolvedConstructorOrFactoryMethod();
            if (constructorToUse == null) {
                Class clazz = beanDefinition.getBeanClass();
                try {
                    constructorToUse = clazz.getDeclaredConstructor();
                    beanDefinition.setResolvedConstructorOrFactoryMethod(constructorToUse);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            return ReflectionUtils.instantiateClass(constructorToUse);
        }
    }

    private Object instantiateWithMethodInjection(BeanDefinition beanDefinition, String beanName) {
        return null;
    }
}
