package com.xcr.spring.core.io;

import java.io.InputStream;

/**
 * @Author: xia
 * @Date: 2021/1/26 10:54
 * @Version: v1.0
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
