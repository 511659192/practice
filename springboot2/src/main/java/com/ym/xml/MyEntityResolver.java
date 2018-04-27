package com.ym.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.CollectionUtils;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ym on 2018/4/25.
 */
public class MyEntityResolver implements EntityResolver {

    private volatile Map<String, String> schemaMappings;
    private final String schemaMappingsLocation = "META-INF/spring.schemas";

    private static final Log logger = LogFactory.getLog(MyEntityResolver.class);
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId != null) {
            String resourceLocation = getSchemaMappings().get(systemId);
            if (resourceLocation != null) {
                Resource resource = new ClassPathResource(resourceLocation, Thread.currentThread().getContextClassLoader());
                try {
                    InputSource source = new InputSource(resource.getInputStream());
                    source.setPublicId(publicId);
                    source.setSystemId(systemId);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Found XML schema [" + systemId + "] in classpath: " + resourceLocation);
                    }
                    return source;
                }
                catch (FileNotFoundException ex) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Couldn't find XML schema [" + systemId + "]: " + resource, ex);
                    }
                }
            }
        }
        return null;
    }

    private Map<String, String> getSchemaMappings() {
        Map<String, String> schemaMappings = this.schemaMappings;
        if (schemaMappings == null) {
            synchronized (this) {
                schemaMappings = this.schemaMappings;
                if (schemaMappings == null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Loading schema mappings from [" + this.schemaMappingsLocation + "]");
                    }
                    try {
                        Properties mappings =
                                PropertiesLoaderUtils.loadAllProperties(this.schemaMappingsLocation, Thread.currentThread().getContextClassLoader());
                        if (logger.isDebugEnabled()) {
                            logger.debug("Loaded schema mappings: " + mappings);
                        }
                        Map<String, String> mappingsToUse = new ConcurrentHashMap<>(mappings.size());
                        CollectionUtils.mergePropertiesIntoMap(mappings, mappingsToUse);
                        schemaMappings = mappingsToUse;
                        this.schemaMappings = schemaMappings;
                    }
                    catch (IOException ex) {
                        throw new IllegalStateException(
                                "Unable to load schema mappings from location [" + this.schemaMappingsLocation + "]", ex);
                    }
                }
            }
        }
        return schemaMappings;
    }
}
