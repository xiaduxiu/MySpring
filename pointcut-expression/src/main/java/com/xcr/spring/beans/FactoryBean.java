package com.xcr.spring.beans;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:33
 * @Version: v1.0
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
