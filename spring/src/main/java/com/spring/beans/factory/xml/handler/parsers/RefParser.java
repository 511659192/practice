package com.spring.beans.factory.xml.handler.parsers;

import com.spring.beans.factory.config.PropertyValue;
import com.spring.beans.factory.config.RuntimeBeanReference;
import com.spring.beans.factory.xml.XmlReaderContext;
import com.spring.beans.factory.xml.handler.HandlerHelper;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import static com.spring.base.Constants.BEAN_ATTRIBUTE;
import static com.spring.base.Constants.REF_ELEMENT;

/**
 * Created by ym on 2018/4/29.
 */
public class RefParser implements Parser {
    @Override
    public boolean support(String uri, String localName, String qName) {
        return StringUtils.equals(localName, REF_ELEMENT);
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext) {
        String beanName = HandlerHelper.getAttrubite(attributes, BEAN_ATTRIBUTE);
        xmlReaderContext.pushToStack(new RuntimeBeanReference(beanName));
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext) {
        RuntimeBeanReference reference = xmlReaderContext.popFromStack();
        PropertyValue propertyValue = xmlReaderContext.peekFromStack();
        propertyValue.setValue(reference);
    }
}
