package com.spring.beans.factory.xml.handler;

import com.google.common.collect.Lists;
import com.spring.beans.factory.xml.XmlReaderContext;
import com.spring.beans.factory.xml.handler.parsers.*;
import org.xml.sax.Attributes;

import java.util.List;

/**
 * Created by ym on 2018/4/29.
 */
public class DefaultParserChain implements ParserChain {

    private XmlReaderContext xmlReaderContext;
    private static List<Parser> parsers = Lists.newArrayList();
    private int startIndex = 0;
    private int endIndex = 0;
    static {
        parsers.add(new NoOpParser());
        parsers.add(new BeanParser());
        parsers.add(new PropertyParser());
        parsers.add(new ConstrutorArgParser());
        parsers.add(new RefParser());
        parsers.add(new ValueParser());
    }

    public DefaultParserChain(XmlReaderContext xmlReaderContext) {
        this.xmlReaderContext = xmlReaderContext;
    }

    public XmlReaderContext getXmlReaderContext() {
        return xmlReaderContext;
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes) {
        if (startIndex < parsers.size()) {
            Parser parser = parsers.get(startIndex++);
            if (parser.support(uri, localName, qName)) {
                parser.parseStartElement(uri, localName, qName, attributes, xmlReaderContext);
            } else {
                parseStartElement(uri, localName, qName, attributes);
            }
            return;
        }
        throw new RuntimeException(String.format("illegal tag uri:%s localName:%s qName:%s attr:%s", uri, localName, qName, HandlerHelper.getAttrubiteString(attributes)));
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName) {
        if (endIndex < parsers.size()) {
            Parser parser = parsers.get(endIndex++);
            if (parser.support(uri, localName, qName)) {
                parser.parseEndElement(uri, localName, qName, xmlReaderContext);
            } else {
                parseEndElement(uri, localName, qName);
            }
            return;
        }
        throw new RuntimeException("illegal tag");
    }
}
