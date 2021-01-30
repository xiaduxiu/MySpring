package com.xcr.spring.context.support;

import com.xcr.spring.beans.factory.config.BeanPostProcessor;
import com.xcr.spring.context.ApplicationContext;
import com.xcr.spring.context.ApplicationContextAware;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:55
 * @Version: v1.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        if(bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
