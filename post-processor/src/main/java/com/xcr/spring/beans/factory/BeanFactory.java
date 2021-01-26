package com.xcr.spring.beans.factory;


/**
 * @author xia
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;
}
