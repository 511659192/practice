package com.spring.beans.factory.xml;

import com.spring.beans.factory.BeanDefinitionRegistry;
import com.spring.beans.factory.xml.handler.DefaultContentHandler;
import com.spring.beans.factory.xml.handler.DefaultEntityResolver;
import com.spring.beans.factory.xml.handler.DefaultErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by ym on 2018/4/26.
 */
public class XmlBeanDefinitionReader {

    private static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    private static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    private static final Logger logger = LoggerFactory.getLogger(XmlBeanDefinitionReader.class);

    private BeanDefinitionRegistry registry;
    private XmlReaderContext xmlReaderContext = new XmlReaderContext(this);

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void parse(InputSource input) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory saxParserFactory = createSaxParserFactory();
        SAXParser parser = createSaxParser(saxParserFactory);
        XMLReader reader = createXmlReader(parser);
        try {
            reader.parse(input);
        } finally {
            xmlReaderContext.clearStack();
        }
    }

    private XMLReader createXmlReader(SAXParser parser) throws SAXException {
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(new DefaultContentHandler(xmlReaderContext)); // 内容处理器
        reader.setEntityResolver(new DefaultEntityResolver()); // schama解析器
        reader.setErrorHandler(new DefaultErrorHandler(xmlReaderContext)); // 异常处理器
        return reader;
    }

    private SAXParser createSaxParser(SAXParserFactory saxParserFactory) throws ParserConfigurationException, SAXException {
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.setProperty(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);
        return parser;
    }

    private SAXParserFactory createSaxParserFactory() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(true); // 是否验证xml，默认false
        saxParserFactory.setNamespaceAware(true); // 是否展示命名空间 默认false
        return saxParserFactory;
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}
