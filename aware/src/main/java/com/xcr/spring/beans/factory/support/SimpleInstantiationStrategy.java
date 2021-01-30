package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: xia
 * @Date: 2021/1/15 17:29
 * @Version: v1.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            System.out.println("使用默认构造器实例化对象");
            return declaredConstructor.newInstance();
        } catch (Exception e) {
            throw new Exception(getClass().getName() + "无默认构造器, 无法实例化");
        }

    }
}
