package com.spring.beans.factory.xml.handler.parsers;

import com.spring.beans.factory.xml.XmlReaderContext;
import org.xml.sax.Attributes;

/**
 * Created by ym on 2018/4/29.
 */
public interface Parser {

    boolean support(String uri, String localName, String qName);

    void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext);

    void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext);
}
