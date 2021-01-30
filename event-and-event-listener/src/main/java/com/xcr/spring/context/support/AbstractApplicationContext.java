package com.xcr.spring.context.support;

import com.xcr.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.xcr.spring.beans.factory.config.BeanPostProcessor;
import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import com.xcr.spring.context.ApplicationEvent;
import com.xcr.spring.context.ApplicationListener;
import com.xcr.spring.context.ConfigurableApplicationContext;
import com.xcr.spring.context.event.ApplicationEventMulticaster;
import com.xcr.spring.context.event.ContextRefreshedEvent;
import com.xcr.spring.context.event.SimpleApplicationEventMulticaster;
import com.xcr.spring.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: xia
 * @Date: 2021/1/28 17:07
 * @Version: v1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws Exception {
        refreshBeanFactory();
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        // 让继承自ApplicationContextAware的bean能感知bean
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        invokeBeanFactoryPostProcessors(beanFactory);
        registerBeanPostProcessors(beanFactory);

        //初始化事件发布者
        initApplicationEventMulticaster();

        //注册事件监听器
        registerListeners();

        beanFactory.preInstantiateSingletons();

        //发布容器刷新完成事件
        finishRefresh();
    }

    /**
     * 初始化事件发布者
     */
    protected void initApplicationEventMulticaster() throws Exception {
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.addSingletonBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    /**
     * 注册事件监听器
     */
    protected void registerListeners() throws Exception {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener applicationListener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(applicationListener);
        }
    }

    /**
     * 发布容器刷新完成事件
     */
    protected void finishRefresh() throws Exception {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) throws Exception {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void invokeBeanFactoryPostProcessors(DefaultListableBeanFactory beanFactory) throws Exception {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor: beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(DefaultListableBeanFactory beanFactory) throws Exception {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor: beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public Object getBean(String name) throws Exception {
        return getBeanFactory().getBean(name);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 创建beanfactory 加载 beandefinition
     */
    protected abstract void refreshBeanFactory() throws Exception;


    protected abstract DefaultListableBeanFactory getBeanFactory();

    @Override
    public void close() {
        doClose();
    }

    private void doClose() {
        destroyBeans();
    }

    private void destroyBeans() {
        try {
            getBeanFactory().destroySingletons();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerShutdownHook() {
        Thread shutdownHook = new Thread() {
            @Override
            public void run() {
                doClose();
            }
        };
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }
}
