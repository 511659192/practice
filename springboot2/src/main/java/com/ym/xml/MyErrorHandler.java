package com.ym.xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Created by ym on 2018/4/25.
 */
public class MyErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("------------warning------------");
        throw exception;
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("------------error------------");
        throw exception;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("------------fatalError------------");
        throw exception;
    }
}
