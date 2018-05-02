package com.spring.beans.factory;

import lombok.Data;

import java.util.Map;

/**
 * Created by ym on 2018/4/28.
 */
@Data
public class Entity {

    private String name;
    private String name2;
    private Map<String, String> map;
    private Entity2 entity2;
    private Entity2 entity;
    public Entity() {
    }

}
