package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @Author: xia
 * @Date: 2021/1/15 16:34
 * @Version: v1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws Exception {
        Object singletonBean = getSingletonBean(beanName);
        if (Objects.nonNull(singletonBean)) {
            return singletonBean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;

    protected abstract Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws Exception;

    protected abstract Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws Exception;
}
