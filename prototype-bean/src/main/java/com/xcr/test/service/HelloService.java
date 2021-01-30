package com.xcr.test.service;

import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.beans.factory.BeanFactoryAware;
import com.xcr.spring.context.ApplicationContext;
import com.xcr.spring.context.ApplicationContextAware;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:00
 * @Version: v1.0
 */
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws Exception {
        this.applicationContext = applicationContext;
    }

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

}
