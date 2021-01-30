package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.FactoryBean;
import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.BeanPostProcessor;

import java.util.*;


/**
 * @Author: xia
 * @Date: 2021/1/15 16:34
 * @Version: v1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws Exception {
        Object singletonBean = getSingletonBean(beanName);
        if (Objects.nonNull(singletonBean)) {
            return getObjectForBeanInstance(singletonBean, beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition);
        return getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object bean, String beanName) throws Exception {
        Object object = bean;
        if (bean instanceof FactoryBean) {
            FactoryBean factoryBean = (FactoryBean) bean;
            try {
                if (factoryBean.isSingleton()) {
                    object = this.factoryBeanObjectCache.get(beanName);
                    if (object == null) {
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName, object);
                    }
                } else {
                    object = factoryBean.getObject();
                }
            } catch (Exception e) {
                throw new Exception("FactoryBean threw exception on object[" + beanName + "] creation", e);
            }
        }
        return object;
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
