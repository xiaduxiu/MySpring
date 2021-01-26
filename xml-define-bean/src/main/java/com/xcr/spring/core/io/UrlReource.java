package com.xcr.spring.core.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:00
 * @Version: v1.0
 */
public class UrlReource implements Resource {

    private final URL url;

    public UrlReource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        return inputStream;
    }
}
