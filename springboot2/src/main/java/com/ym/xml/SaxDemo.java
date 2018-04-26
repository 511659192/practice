package com.ym.xml;

import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by ym on 2018/4/25.
 */
public class SaxDemo {
    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(true); // 是否验证xml，默认false
        saxParserFactory.setNamespaceAware(true); // 是否展示命名空间 默认false
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(new MyDefalutHandler()); // 内容处理器
        reader.setEntityResolver(new MyEntityResolver()); // schama解析器
        reader.setErrorHandler(new MyErrorHandler()); // 异常处理器
        reader.parse(SaxDemo.class.getResource("/").getPath() + "/saxDemo.xml");
    }
}
