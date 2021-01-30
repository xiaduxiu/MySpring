package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.DisposableBean;
import com.xcr.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:51
 * @Version: v1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjectMap = new ConcurrentHashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonObjectMap.get(beanName);
    }

    protected void addSingletonBean(String beanName, Object singleObject) {
        singletonObjectMap.put(beanName, singleObject);
    }

    public void registryDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() throws Exception {
        Set<String> beanNames = disposableBeans.keySet();
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.get(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new Exception("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

}
