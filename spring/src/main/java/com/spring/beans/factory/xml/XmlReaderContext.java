package com.spring.beans.factory.xml;

import java.util.Stack;

/**
 * Created by ym on 2018/4/28.
 */
public class XmlReaderContext {

    private XmlBeanDefinitionReader xmlBeanDefinitionReader;
    private NamespaceHandlerResolver namespaceHandlerResolver = new DefaultNamespaceHandlerResolver();
    private Stack<Object> stack = new Stack();

    public XmlReaderContext(XmlBeanDefinitionReader xmlBeanDefinitionReader) {
        this.xmlBeanDefinitionReader = xmlBeanDefinitionReader;
    }

    public XmlBeanDefinitionReader getXmlBeanDefinitionReader() {
        return xmlBeanDefinitionReader;
    }

    public <T> T popFromStack() {
        return (T) stack.pop();
    }

    public <T> T pushToStack(T t) {
        return (T) stack.push(t);
    }

    public <T> T peekFromStack() {
        return (T) stack.peek();
    }

    public void clearStack() {
        if (stack.empty()) return;
        stack.clear();
    }

    public int stackSize() {
        return stack.size();
    }
}
