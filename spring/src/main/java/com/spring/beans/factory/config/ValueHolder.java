package com.spring.beans.factory.config;

import lombok.Data;

/**
 * Created by ym on 2018/4/29.
 */
@Data
public class ValueHolder {

    private Object value;

    private String type;

    public ValueHolder(Object value) {
        this.value = value;
    }

    public ValueHolder() {
    }
}
