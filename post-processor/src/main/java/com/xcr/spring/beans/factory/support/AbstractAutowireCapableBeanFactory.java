package com.xcr.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.xcr.spring.beans.PropertyValue;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.BeanReference;

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
        Object bean = createBeanInstance(beanDefinition);
        // bean属性填充
        applyPropertyValues(beanName, bean, beanDefinition);
        addSingletonBean(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
         try {
             for (PropertyValue propertyValue: beanDefinition.getPropertyValues().getPropertyValues()) {
                 String name = propertyValue.getName();
                 Object value = propertyValue.getValue();
                 if (value instanceof BeanReference) {
                     value = getBean(((BeanReference) value).getBeanName());
                 }
                 BeanUtil.setFieldValue(bean, name, value);
             }
         } catch (Exception ex) {
             throw new Exception("Error setting property values for bean: " + beanName, ex);
         }
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
