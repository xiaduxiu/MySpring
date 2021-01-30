package com.xcr.spring.beans.factory.config;

/**
 * bean对其他bean的引用
 * @Author: xia
 * @Date: 2021/1/26 10:23
 * @Version: v1.0
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
