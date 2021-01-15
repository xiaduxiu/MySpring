package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.BeanDefinition;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:42
 * @Version: v1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
//        Object bean = beanClass.newInstance();
        Object bean = createBeanInstance(beanDefinition);
        addSingletonBean(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
