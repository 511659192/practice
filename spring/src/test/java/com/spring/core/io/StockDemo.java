package com.spring.core.io;

import com.alibaba.fastjson.JSON;
import com.spring.beans.factory.Entity;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ym on 2018/4/28.
 */
public class StockDemo {

    public static void main(String[] args) {
        Stack<Entity> stack = new Stack<>();
        System.out.println(JSON.toJSONString(stack.peek()));
        Entity entity = stack.peek();
        entity.setMap(new HashMap<String, String>());
        entity.getMap().put("key", "value");
        System.out.println(JSON.toJSONString(stack.peek()));
        System.out.println(JSON.toJSONString(stack.pop()));
        System.out.println(JSON.toJSONString(stack.peek()));
        System.out.println(JSON.toJSONString(stack.pop()));
        System.out.println(JSON.toJSONString(stack.peek()));
    }
}
