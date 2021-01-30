package com.xcr.spring.beans.factory;


import java.util.Map;

/**
 * @author xia
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    <T> T getBean(String name, Class<T> requiredType) throws Exception;

    <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception;

    String[] getBeanDefinitionNames();
}
