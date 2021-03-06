package com.spring.beans.factory.xml.handler.parsers;

import com.spring.beans.factory.xml.XmlReaderContext;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import static com.spring.base.Constants.CONSTRUCTOR_ARG_ELEMENT;

/**
 * Created by ym on 2018/4/29.
 */
public class ConstrutorArgParser implements Parser {
    @Override
    public boolean support(String uri, String localName, String qName) {
        return StringUtils.equals(localName, CONSTRUCTOR_ARG_ELEMENT);
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext) {
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext) {
    }
}
