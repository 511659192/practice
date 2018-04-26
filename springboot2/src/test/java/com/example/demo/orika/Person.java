package com.example.demo.orika;

import java.util.List;

/**
 * Created by ym on 2018/3/31.
 */
public class Person <T> {
    private List<Name> names;
    private List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}
