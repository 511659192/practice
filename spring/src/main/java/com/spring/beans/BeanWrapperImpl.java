package com.spring.beans;

/**
 * Created by ym on 2018/5/2.
 */
public class BeanWrapperImpl implements BeanWrapper {

    private TypeConverterDelegate typeConverterDelegate;
    private Object wrappedObject;

    public BeanWrapperImpl(Object object) {
        this.wrappedObject = object;
//        this.typeConverterDelegate = new TypeConverterDelegate(this, this.wrappedObject);
    }
}
