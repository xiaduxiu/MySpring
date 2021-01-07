package com.xcr.spring.beans.factory;

import com.xcr.spring.beans.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author 12037
 */
public interface BeanFactory {

    /**
     * 获取bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

}
