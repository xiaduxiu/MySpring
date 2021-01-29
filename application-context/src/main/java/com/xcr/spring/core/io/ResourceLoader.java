package com.xcr.spring.core.io;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:02
 * @Version: v1.0
 */
public interface ResourceLoader {
    Resource getResource(String location) throws Exception;
}
