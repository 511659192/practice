package com.example.demo.spring;

import com.alibaba.fastjson.JSON;
import com.example.demo.springTag.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by ym on 2018/2/1.
 */
public class XmlTest {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        factory.getBean("testA");
//        User user = (User) factory.getBean("userTag");
//        System.out.println(JSON.toJSONString(user));
    }
}
