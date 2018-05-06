package com.spring.beans;

import java.beans.PropertyDescriptor;

/**
 * Created by ym on 2018/5/2.
 */
public interface BeanWrapper {

    Object getWrappedObject();

    Class<?> getWrappedClass();

    PropertyDescriptor[] getPropertyDescriptors();
}
