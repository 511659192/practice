package com.spring.beans.factory.xml.handler;

import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Node;

/**
 * Created by ym on 2018/4/27.
 */
public class HandlerHelper {

    public static final String BEANS_NAMESPACE_URI = "http://www.springframework.org/schema/beans";

    public static boolean isDefaultNamespace(@Nullable String namespaceUri) {
        return (!StringUtils.isNotBlank(namespaceUri) || BEANS_NAMESPACE_URI.equals(namespaceUri));
    }
}
