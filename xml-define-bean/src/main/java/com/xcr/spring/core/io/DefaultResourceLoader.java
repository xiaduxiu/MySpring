package com.xcr.spring.core.io;


import java.net.URL;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:02
 * @Version: v1.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    private final String CLASSPATH_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) throws Exception {
        if (location.startsWith(CLASSPATH_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlReource(url);
            } catch (Exception ex) {
                return new FileSystemResource(location);
            }
        }
    }
}
