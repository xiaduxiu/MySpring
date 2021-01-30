package com.xcr.spring.beans.factory;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:50
 * @Version: v1.0
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws Exception;

}
