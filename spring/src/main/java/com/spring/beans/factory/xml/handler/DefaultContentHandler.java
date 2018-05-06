package com.spring.beans.factory.xml.handler;

import com.spring.beans.factory.config.ValueHolder;
import com.spring.beans.factory.xml.XmlReaderContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by ym on 2018/4/27.
 */
public class DefaultContentHandler extends DefaultHandler {


    private XmlReaderContext xmlReaderContext;

    public DefaultContentHandler(XmlReaderContext xmlReaderContext) {
        this.xmlReaderContext = xmlReaderContext;
    }

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("DefaultContentHandler.startDocument()");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println(String.format("startElement uri=%s localName=%s qname=%s attr=%s", uri, localName, qName, HandlerHelper.getAttrubiteString(attributes)));
        new DefaultParserChain(xmlReaderContext).parseStartElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        ValueHolder valueHolder = xmlReaderContext.peekFromStack();
        valueHolder.setValue(content);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println(String.format("endElement uri=%s localName=%s qname=%s", uri, localName, qName));
        new DefaultParserChain(xmlReaderContext).parseEndElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefalutHandler.endDocument()");
    }
}
