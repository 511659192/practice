package com.spring.beans.factory.xml.handler;

import com.spring.beans.factory.xml.XmlReaderContext;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by ym on 2018/4/27.
 */
public class DefaultErrorHandler extends DefaultHandler {

    private XmlReaderContext xmlReaderContext;

    public DefaultErrorHandler(XmlReaderContext xmlReaderContext) {
        this.xmlReaderContext = xmlReaderContext;
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        throw exception;
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        throw exception;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        throw exception;
    }
}