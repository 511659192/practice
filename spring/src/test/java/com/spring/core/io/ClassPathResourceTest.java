package com.spring.core.io;

import org.junit.Test;

/**
 * Created by ym on 2018/4/27.
 */
public class ClassPathResourceTest {

    @Test
    public void getInputStream() throws Exception {
        ClassPathResource resource = new ClassPathResource("beans2.xml", ClassPathResourceTest.class);
        resource.getInputStream();
    }

}