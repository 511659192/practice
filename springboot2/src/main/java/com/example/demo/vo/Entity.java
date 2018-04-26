package com.example.demo.vo;

import com.example.demo.springTag.User;

import java.util.List;
import java.util.Map;

/**
 * Created by ym on 2018/4/5.
 */
public class Entity {

    private Map<String, String> map;

    private List<Integer> list;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    private Long id;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}