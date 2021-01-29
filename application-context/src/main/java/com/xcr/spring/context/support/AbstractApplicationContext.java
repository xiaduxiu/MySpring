package com.xcr.spring.context.support;

import com.xcr.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.xcr.spring.beans.factory.config.BeanPostProcessor;
import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import com.xcr.spring.context.ConfigurableApplicationContext;
import com.xcr.spring.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author: xia
 * @Date: 2021/1/28 17:07
 * @Version: v1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws Exception {
        refreshBeanFactory();
        DefaultListableBeanFactory beanFactory = getBeanFactory();
        invokeBeanFactoryPostProcessors(beanFactory);
        registerBeanPostProcessors(beanFactory);
        beanFactory.preInstantiateSingletons();
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
}
