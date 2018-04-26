package com.example.demo.orika;

import java.util.List;

/**
 * Created by ym on 2018/3/31.
 */
public class Base<T> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
