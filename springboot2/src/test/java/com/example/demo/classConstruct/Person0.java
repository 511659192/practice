package com.example.demo.classConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ym on 2018/4/1.
 */
@Controller
public class Person0 {

    private String name;

    public String getName() {
        return name;
    }

    @RequestMapping
    @ResponseBody
    public void setName(@PathVariable String name) {
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

