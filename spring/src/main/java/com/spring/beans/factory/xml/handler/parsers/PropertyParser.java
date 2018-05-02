package com.spring.beans.factory.xml.handler.parsers;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.PropertyValue;
import com.spring.beans.factory.config.RuntimeBeanReference;
import com.spring.beans.factory.config.ValueHolder;
import com.spring.beans.factory.xml.XmlReaderContext;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import static com.spring.base.Constants.*;
import static com.spring.beans.factory.xml.handler.HandlerHelper.getAttrubite;

/**
 * Created by ym on 2018/4/29.
 */
public class PropertyParser implements Parser {
    @Override
    public boolean support(String uri, String localName, String qName) {
        return StringUtils.equals(localName, PROPERTY_ELEMENT);
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext) {
        String propertyName = getAttrubite(attributes, "name");
        if (StringUtils.isBlank(propertyName)) {
            throw new RuntimeException("propertyName can not be null");
        }

        Object val = parsePropertyValue(uri, attributes, propertyName);
        PropertyValue pv = new PropertyValue(propertyName, val);
        xmlReaderContext.pushToStack(pv);
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext) {
        PropertyValue pv = xmlReaderContext.popFromStack();
        BeanDefinition beanDefinition = xmlReaderContext.peekFromStack();
        beanDefinition.addPropertyValue(pv);
    }

    private Object parsePropertyValue(String uri, Attributes attributes, String propertyName) {
        String value = getAttrubite(attributes, VALUE_ATTRIBUTE);
        if (StringUtils.isNotBlank(value)) {
            return new ValueHolder(value);
        }

        String ref = getAttrubite(attributes, REF_ELEMENT);
        if (StringUtils.isNotBlank(ref)) {
            return new RuntimeBeanReference(ref);
        }
        return null;
    }

}
