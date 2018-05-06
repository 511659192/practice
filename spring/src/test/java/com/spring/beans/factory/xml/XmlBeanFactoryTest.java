package com.spring.beans.factory.xml;

import com.spring.beans.factory.Entity;
import com.spring.beans.factory.Entity2;
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
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory("beans.xml");
        Entity entity = xmlBeanFactory.getBean("entity");
        System.out.println(entity.getEntity2().getEntity().getName2());
//        Entity2 entity2 = xmlBeanFactory.getBean("entity2");
//        System.out.println(entity2);

    }

}