package com.example.demo.classConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ym on 2018/4/1.
 */
@Controller
public class Person2 <E> {

    private E name;

    public E getName() {
        return name;
    }

    @RequestMapping
    @ResponseBody
    public void setName(@PathVariable E name) {
        this.name = name;
    }

    public <T> T getT() {
        return (T) new Object();
    }
}
