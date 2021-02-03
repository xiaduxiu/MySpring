package com.xcr.spring.beans.factory.config;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:13
 * @Version: v1.0
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
