package com.spring.beans.factory.xml.handler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

/**
 * Created by ym on 2018/4/27.
 */
public class DefaultEntityResolver extends DefaultHandler {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        return super.resolveEntity(publicId, systemId);
    }
}
