package com.spring.beans.factory.config;

import com.sun.istack.internal.Nullable;

/**
 * Created by ym on 2018/4/26.
 */
public interface BeanDefinition {

    void setBeanClassName(@Nullable String beanClassName);

    @Nullable
    String getBeanClassName();

    ConstructorArgumentValues getConstructorArgumentValues();

    default boolean hasConstructorArgumentValues() {
        return !getConstructorArgumentValues().isEmpty();
    }

    MutablePropertyValues getPropertyValues();

    default boolean hasPropertyValues() {
        return !getPropertyValues().isEmpty();
    }
}
