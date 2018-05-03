package com.spring.beans.factory.xml.handler.parsers;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.spring.beans.factory.BeanDefinitionRegistry;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.xml.XmlReaderContext;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import java.util.List;

import static com.spring.base.Constants.*;
import static com.spring.beans.factory.xml.handler.HandlerHelper.getAttrubite;

/**
 * Created by ym on 2018/4/29.
 */
public class BeanParser implements Parser {
    @Override
    public boolean support(String uri, String localName, String qName) {
        return StringUtils.equals(localName, BEAN_ELEMENT);
    }

    @Override
    public void parseStartElement(String uri, String localName, String qName, Attributes attributes, XmlReaderContext xmlReaderContext) {
        String id = getAttrubite(attributes, "id");
        String nameAttr = getAttrubite(attributes, "name");
        List<String> aliases = Lists.newArrayList();
        if (StringUtils.isNotBlank(nameAttr)) {
            aliases.addAll(Splitter.on(",").splitToList(nameAttr));
        }

        String beanName = id;
        if (StringUtils.isBlank(beanName) && aliases.size() > 0) {
            beanName = aliases.remove(0);
        }

        BeanDefinition beanDefinition = parseBeanDefinition(uri, attributes, beanName);
        beanDefinition.setBeanName(beanName);
        String initMethod = getAttrubite(attributes, INIT_METHOD_ATTRIBUTE);
        if (StringUtils.isNotBlank(initMethod)) {
            beanDefinition.setInitMethod(initMethod);
        }

        String destoryMethod = getAttrubite(attributes, DESTROY_METHOD_ATTRIBUTE);
        if (StringUtils.isNotBlank(destoryMethod)) {
            beanDefinition.setDestoryMethod(destoryMethod);
        }
        if (aliases.size() > 0) {
            beanDefinition.setAlias(aliases);
        }
        xmlReaderContext.pushToStack(beanDefinition);
    }

    @Override
    public void parseEndElement(String uri, String localName, String qName, XmlReaderContext xmlReaderContext) {
        Preconditions.checkArgument(xmlReaderContext.stackSize() == 1);
        BeanDefinition beanDefinition = xmlReaderContext.popFromStack();
        BeanDefinitionRegistry registry = xmlReaderContext.getXmlBeanDefinitionReader().getRegistry();
        String beanName = beanDefinition.getBeanName();
        registry.registerBeanDefinition(beanName, beanDefinition);
        List<String> alias = beanDefinition.getAlias();
        if (alias != null && alias.size() > 0) {
            for (String aliasName : alias) {
                registry.registerAlias(beanName, aliasName);
            }
        }
    }

    private BeanDefinition parseBeanDefinition(String uri, Attributes attributes, String beanName) {
        BeanDefinition beanDefinition = new BeanDefinition();
        String className = getAttrubite(attributes, CLASS_ATTRIBUTE);
        if (StringUtils.isNotBlank(className)) {
            try {
                beanDefinition.setBeanClass(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return beanDefinition;
    }

}
