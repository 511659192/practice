package com.spring.beans.factory.xml;

import com.spring.core.io.ClassPathResource;
import org.junit.Test;
import org.xml.sax.InputSource;

/**
 * Created by ym on 2018/4/27.
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void parse() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(null);
        reader.parse(new InputSource(new ClassPathResource("beans.xml").getInputStream()));
    }

}