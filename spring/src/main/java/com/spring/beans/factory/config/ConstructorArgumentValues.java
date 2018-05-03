package com.spring.beans.factory.config;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ym on 2018/5/2.
 */
@Data
public class ConstructorArgumentValues {
    private final Map<Integer, ValueHolder> indexedArgumentValues = new LinkedHashMap<>(0);

    private final List<ValueHolder> genericArgumentValues = new LinkedList<>();

    public boolean isEmpty() {
        return indexedArgumentValues.isEmpty() && genericArgumentValues.isEmpty();
    }
}
