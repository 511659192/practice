package com.spring.beans.factory.xml;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.core.io.ClassPathResource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * Created by ym on 2018/4/26.
 */
public class XmlBeanFactory extends DefaultListableBeanFactory {

    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

    public XmlBeanFactory(String resource) throws RuntimeException, SAXException, ParserConfigurationException, IOException {
        this(new ClassPathResource(resource));
    }

    public XmlBeanFactory(ClassPathResource resource) throws RuntimeException, SAXException, ParserConfigurationException, IOException {
        this.reader.parse(new InputSource(resource.getInputStream()));
    }


    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = resolveBeanClass(beanDefinition, beanName);
        Object bean = null;
        try {
//            bean = resolveBeforeInstantiation(beanName, beanDefinition);
//            if (bean != null) {
//                return bean;
//            }
            Constructor<?> constructorToUse = clazz.getDeclaredConstructor();
            bean = constructorToUse.newInstance(new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    private Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    private Class<?> resolveBeanClass(BeanDefinition beanDefinition, String beanName) {
        if (beanDefinition.hasBeanClass()) {
            return beanDefinition.getBeanClass();
        }

        Class<?> clazz = beanDefinition.resolveBeanClass();
        return clazz;
    }
}
