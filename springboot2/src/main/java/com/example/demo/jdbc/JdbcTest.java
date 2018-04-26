package com.example.demo.jdbc;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ym on 2018/4/21.
 */
public class JdbcTest {

    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir") + "/generatedCode");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        User user = userService.get("020b08e1f038471ba30a63da9190d859");
//        System.out.println(JSON.toJSONString(user));

        MultiService userService = (MultiService) applicationContext.getBean("multiService");
        User user = userService.get("020b08e1f038471ba30a63da9190d859");
        System.out.println(JSON.toJSONString(user));
    }
}
