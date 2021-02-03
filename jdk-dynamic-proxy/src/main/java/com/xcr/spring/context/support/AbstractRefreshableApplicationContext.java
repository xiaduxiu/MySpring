package com.xcr.spring.context.support;

import com.xcr.spring.beans.factory.support.BeanDefinitionRegistry;
import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: xia
 * @Date: 2021/1/28 17:47
 * @Version: v1.0
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception;

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
