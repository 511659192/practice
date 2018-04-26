package com.example.demo.spring;

import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by ym on 2018/2/1.
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        context.getBean("testA");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\classes");
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        TestBean bean = (TestBean) context.getBean("testBean");
        bean.test();
    }
}
