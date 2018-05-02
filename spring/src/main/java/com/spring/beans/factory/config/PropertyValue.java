package com.spring.beans.factory.config;

import lombok.Data;

/**
 * Created by ym on 2018/4/29.
 */
@Data
public class PropertyValue {

    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
