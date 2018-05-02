package com.spring.core;

/**
 * Created by ym on 2018/4/29.
 */
public class DefaultReference {

    private Object reference;

    public <T> T getReference() {
        return (T) reference;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }
}
