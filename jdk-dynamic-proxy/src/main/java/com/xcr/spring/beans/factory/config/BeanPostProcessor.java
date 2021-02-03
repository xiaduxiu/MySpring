package com.xcr.spring.beans.factory.config;

/**
 * @Author: xia
 * @Date: 2021/1/28 15:31
 * @Version: v1.0
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
