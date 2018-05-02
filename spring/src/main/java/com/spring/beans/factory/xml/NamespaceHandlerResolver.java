package com.spring.beans.factory.xml;

/**
 * Created by ym on 2018/4/28.
 */
public interface NamespaceHandlerResolver {

    NamespaceHandler resolve(String namespaceUri);
}
