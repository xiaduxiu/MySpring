package com.xcr.spring.beans.factory.config;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:31
 * @Version: v1.0
 */
public class BeanDefinition {

    private Class beanClass;
    private String className;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
