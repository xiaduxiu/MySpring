package com.xcr.test;

import com.xcr.spring.beans.factory.config.BeanPostProcessor;

/**
 * @Author: xia
 * @Date: 2021/1/26 14:56
 * @Version: v1.0
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("this is postProcessBeforeInitialization");
        if (beanName.equals("car")) {
            ((Car) bean).setBrand("tttt");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("this is postProcessAfterInitialization");
        return bean;
    }
}
