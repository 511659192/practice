package com.ym.xml;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefalutHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument()");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder builder = new StringBuilder();
        int length = attributes.getLength();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                builder.append(attributes.getLocalName(i).trim())
                        .append(":")
                        .append(attributes.getValue(i).trim())
                        .append(" ");
            }
        }

        System.out.println(String.format("startElement uri=%s localName=%s qname=%s attributes=%s", uri, localName, qName, builder));
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (StringUtils.isNotBlank(content)) {
            System.out.println("characters=" + content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(String.format("startElement uri=%s localName=%s qname=%s", uri, localName, qName));
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument()");
    }
}