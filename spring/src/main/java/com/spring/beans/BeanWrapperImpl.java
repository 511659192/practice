package com.spring.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Created by ym on 2018/5/2.
 */
public class BeanWrapperImpl implements BeanWrapper {

    private Object wrappedObject;
    private CachedIntrospectionResults cachedIntrospectionResults;

    public BeanWrapperImpl(Object object) {
        this.wrappedObject = object;
    }

    public Object getWrappedObject() {
        return wrappedObject;
    }

    @Override
    public Class<?> getWrappedClass() {
        return this.wrappedObject.getClass();
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getCachedIntrospectionResults().getPropertyDescriptors();
    }
    
    private CachedIntrospectionResults getCachedIntrospectionResults() {
        if (this.cachedIntrospectionResults == null) {
            this.cachedIntrospectionResults = CachedIntrospectionResults.forClass(getWrappedClass());
        }
        return this.cachedIntrospectionResults;
    }

}
