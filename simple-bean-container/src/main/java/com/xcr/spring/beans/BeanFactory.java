package com.xcr.spring.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BeanFactory {
    private Map<String, Object> beanMap = new ConcurrentHashMap<>();

    public void register(String beanName, Object bean) {
        beanMap.put(beanName, bean);
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
