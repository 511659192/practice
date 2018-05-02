package com.spring.beans.factory;

import lombok.Data;

import java.util.Map;

/**
 * Created by ym on 2018/4/28.
 */
@Data
public class Entity2 {

    private String name;
    private Map<String, String> map;
    private Entity entity;

}
