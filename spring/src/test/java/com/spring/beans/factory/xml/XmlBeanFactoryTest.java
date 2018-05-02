package com.spring.beans.factory.xml;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by ym on 2018/4/29.
 */
public class XmlBeanFactoryTest {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {
        new XmlBeanFactory("beans.xml").getBean("entity");
    }

}