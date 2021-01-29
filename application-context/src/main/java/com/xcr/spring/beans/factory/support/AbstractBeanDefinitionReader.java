package com.xcr.spring.beans.factory.support;

import com.xcr.spring.core.io.DefaultResourceLoader;
import com.xcr.spring.core.io.ResourceLoader;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:38
 * @Version: v1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private ResourceLoader resourceLoader;

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(new DefaultResourceLoader(), beanDefinitionRegistry);
    }


    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry beanDefinitionRegistry) {
        this.resourceLoader = resourceLoader;
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws Exception {
        for (String location : locations) {
            this.loadBeanDefinitions(location);
        }
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
