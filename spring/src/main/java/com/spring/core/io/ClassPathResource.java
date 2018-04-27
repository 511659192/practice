package com.spring.core.io;

import java.io.InputStream;

/**
 * Created by ym on 2018/4/27.
 */
public class ClassPathResource {

    private String path;
    private ClassLoader classLoader = Thread.currentThread().getContextClassLoader();;
    private Class clazz;

    public ClassPathResource(String path) {
        this.path = path;
    }

    public ClassPathResource(String path, Class clazz) {
        this.path = path;
        this.clazz = clazz;
    }

    public InputStream getInputStream() {
        InputStream is;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(path);
        } else if (this.classLoader != null) {
            is = this.classLoader.getResourceAsStream(path);
        } else {
            is = ClassLoader.getSystemResourceAsStream(this.path);
        }
        if (is == null) {
            throw new RuntimeException("file can not be found");
        }
        return is;
    }
}
