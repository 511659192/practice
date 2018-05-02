package com.spring.beans.factory.config;

import lombok.Data;

/**
 * Created by ym on 2018/4/29.
 */
@Data
public class RuntimeBeanReference {
    private String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }
}
