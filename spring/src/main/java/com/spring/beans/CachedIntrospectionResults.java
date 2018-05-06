package com.spring.beans;

import com.google.common.base.Preconditions;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ym on 2018/5/5.
 */
public class CachedIntrospectionResults {

    private static final ConcurrentMap<Class<?>, CachedIntrospectionResults> cache =
            new ConcurrentHashMap<>(64);
    private final PropertyDescriptor[] propertyDescriptors;
    private BeanInfo beanInfo;

    public CachedIntrospectionResults(Class<?> beanClass) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        this.beanInfo = beanInfo;
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        this.propertyDescriptors = propertyDescriptors;
    }

    public static CachedIntrospectionResults forClass(Class<?> beanClass) throws RuntimeException {
        Preconditions.checkNotNull(beanClass);
        CachedIntrospectionResults results = cache.get(beanClass);
        if (results != null) {
            return results;
        }
        results = new CachedIntrospectionResults(beanClass);
        cache.putIfAbsent(beanClass, results);
        return results;
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
        return this.propertyDescriptors;
    }
}
