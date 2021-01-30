package com.xcr.spring.beans.factory.config;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:50
 * @Version: v1.0
 */
public interface SingletonBeanRegistry {

    Object getSingletonBean(String beanName);
}
