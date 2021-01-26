package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.BeanDefinition;

/**
 * @Author: xia
 * @Date: 2021/1/15 17:29
 * @Version: v1.0
 */
public class CglibInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws Exception {
        throw new UnsupportedOperationException("CGLIB instantiation strategy is not supported");
    }
}
