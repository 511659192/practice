package com.spring.beans.factory.xml;

import com.spring.beans.factory.DefaultListableBeanFactory;
import com.spring.core.io.ClassPathResource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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
}
