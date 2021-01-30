package com.xcr.spring.beans.factory.config;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:34
 * @Version: v1.0
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
