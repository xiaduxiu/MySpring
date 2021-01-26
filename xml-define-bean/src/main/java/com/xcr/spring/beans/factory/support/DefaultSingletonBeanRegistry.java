package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:51
 * @Version: v1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjectMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonObjectMap.get(beanName);
    }

    protected void addSingletonBean(String beanName, Object singleObject) {
        singletonObjectMap.put(beanName, singleObject);
    }

}
