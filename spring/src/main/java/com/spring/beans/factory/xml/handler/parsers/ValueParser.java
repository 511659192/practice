package com.spring.beans.factory.xml.handler.parsers;

import com.spring.beans.factory.config.PropertyValue;
import com.spring.beans.factory.config.ValueHolder;
import com.spring.beans.factory.xml.XmlReaderContext;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import static com.spring.base.Constants.VALUE_ATTRIBUTE;

/**
 * Created by ym on 2018/4/29.
 */
public class ValueParser implements Parser {
    @Override
    public boolean support(String uri, String localName, String qName) {
        return StringUtils.equals(localName, VALUE_ATTRIBUTE);
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext) {
        xmlReaderContext.pushToStack(new ValueHolder());
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext) {
        ValueHolder valueHolder = xmlReaderContext.popFromStack();
        PropertyValue propertyValue = xmlReaderContext.peekFromStack();
        propertyValue.setValue(valueHolder);
    }
}
