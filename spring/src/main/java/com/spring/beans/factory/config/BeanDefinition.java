package com.spring.beans.factory.config;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import com.sun.org.apache.regexp.internal.REUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;

/**
 * Created by ym on 2018/4/26.
 */
@Data
public class BeanDefinition {

    private Object beanClass;
    private String initMethod;
    private String destoryMethod;
    private List<PropertyValue> propertyValues = Lists.newArrayList();
    private ConstructorArgumentValues constructorArgumentValues;
    private String beanName;
    private List<String> alias;
    public Object constructorArgumentLock = new Object();
    public Object resolvedConstructorOrFactoryMethod;

    public <T> T getResolvedConstructorOrFactoryMethod() {
        return (T) resolvedConstructorOrFactoryMethod;
    }

    @Nullable
    public String getBeanClassName() {
        if (beanClass instanceof  Class) {
            return ((Class) beanClass).getName();
        }
        return (String) beanClass;
    };

    public Class<?> getBeanClass() {
        return (Class<?>) beanClass;
    }

    public boolean hasPropertyValues() {
        return !propertyValues.isEmpty();
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        Preconditions.checkNotNull(propertyValue);
        propertyValues.add(propertyValue);
    }

    public boolean hasBeanClass() {
        return this.beanClass instanceof Class;
    }

    public Class<?> resolveBeanClass() {
        String className = this.getBeanClassName();
        if (StringUtils.isBlank(className)) return null;
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not found ", e);
        }
    }

    public boolean hasConstractArgumentValues() {
        return this.constructorArgumentValues != null && !this.constructorArgumentValues.isEmpty();
    }

    public boolean hasMethodOverrides() {
        return false;
    }
}
