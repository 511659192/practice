package com.example.demo.classConstruct;

/**
 * Created by ym on 2018/4/1.
 */
public class Person1 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getT() {
        return "111";
    }

    private void cast() {
        int i = 1;
        Integer j = new Integer(i);
        int k = i;
    }
}

