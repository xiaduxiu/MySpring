package com.xcr.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.xcr.spring.beans.PropertyValue;
import com.xcr.spring.beans.factory.BeanFactoryAware;
import com.xcr.spring.beans.factory.config.*;

import java.lang.reflect.Method;

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
        initializeBean(beanName, bean, beanDefinition);

        // 注册拥有销毁方法的bean
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        if (beanDefinition.isSingleton()) {
            addSingletonBean(beanName, bean);
        }

        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton()) {
            String destroyMethodName = beanDefinition.getDestroyMethodName();
            if (StrUtil.isNotBlank(destroyMethodName) || bean instanceof DisposableBean) {
                registryDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
            }
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 进行aware感知
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        // 执行 前置处理
        Object result = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        // 执行bean的初始化方法
        try {
            invokeInitMethods(beanName, result, beanDefinition);
        } catch (Throwable ex) {
            throw new Exception("Invocation of init method of bean[" + beanName + "] failed", ex);
        }
        // 执行后置处理
        result = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return result;
    }

    /**
     * bean的初始化
    * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotBlank(initMethodName)) {
            Method initMethod = ClassUtil.getPublicMethod(beanDefinition.getBeanClass(), initMethodName);
            if (initMethod == null) {
                throw new Exception("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }

    @Override
    protected Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws Exception {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor: getBeanPostProcessors()){
            Object o = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (o == null) {
                return result;
            }
            result = o;
        }
        return result;
    }

    @Override
    protected Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws Exception {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor: getBeanPostProcessors()){
            Object o = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (o == null) {
                return result;
            }
            result = o;
        }
        return result;
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
