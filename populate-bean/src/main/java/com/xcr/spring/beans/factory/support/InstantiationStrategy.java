package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.BeanDefinition;

/**
 * @Author: xia
 * @Date: 2021/1/15 17:28
 * @Version: v1.0
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws Exception;
}
