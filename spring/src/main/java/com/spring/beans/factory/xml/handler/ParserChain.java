package com.spring.beans.factory.xml.handler;

import com.spring.beans.factory.xml.XmlReaderContext;
import org.xml.sax.Attributes;

/**
 * Created by ym on 2018/4/29.
 */
public interface ParserChain {

    void parseStartElement(String uri, String localName, String qName, Attributes attributes);

    void parseEndElement(String uri, String localName, String qName);

    XmlReaderContext getXmlReaderContext();
}
