package com.xcr.spring.context.event;

import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.beans.factory.BeanFactoryAware;
import com.xcr.spring.context.ApplicationEvent;
import com.xcr.spring.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xia
 * @Date: 2021/1/30 15:40
 * @Version: v1.0
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    private final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();
    private BeanFactory beanFactory;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = beanFactory;
    }

    public Set<ApplicationListener<ApplicationEvent>> getApplicationListeners(){
        return this.applicationListeners;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }
}
