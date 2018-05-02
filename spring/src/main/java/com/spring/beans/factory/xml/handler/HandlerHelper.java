package com.spring.beans.factory.xml.handler;

import com.google.common.collect.Maps;
import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;

import java.util.Map;
import java.util.Objects;

/**
 * Created by ym on 2018/4/27.
 */
public class HandlerHelper {

    public static final String BEANS_NAMESPACE_URI = "http://www.springframework.org/schema/beans";

    public static boolean isDefaultNamespace(@Nullable String namespaceUri) {
        return BEANS_NAMESPACE_URI.equals(namespaceUri);
    }

    public static String getAttrubite(Attributes attributes, String name) {
        if (attributes != null) {
            for (int i = 0, len = attributes.getLength(); i < len; i++) {
                String localName = attributes.getLocalName(i);
                if (StringUtils.equals(localName, name)) {
                    return attributes.getValue(i);
                }
            }
        }
        return null;
    }

    public static String getAttrubiteString(Attributes attributes) {
        StringBuilder builder = new StringBuilder();
        if (attributes != null) {
            for (int i = 0, length = attributes.getLength(); i < length; i++) {
                builder.append(attributes.getLocalName(i).trim()).append(":").append(attributes.getValue(i).trim()).append(" ");
            }
        }
        return builder.toString();
    }
}
