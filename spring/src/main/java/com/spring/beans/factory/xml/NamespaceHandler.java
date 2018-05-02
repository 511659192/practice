package com.spring.beans.factory.xml;

import com.spring.beans.factory.config.BeanDefinition;
import org.w3c.dom.Element;

/**
 * Created by ym on 2018/4/28.
 */
public interface NamespaceHandler {

    void init();

    BeanDefinition parse(ParserContext parserContext);
}
