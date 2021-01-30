package com.xcr.test;

import com.xcr.spring.beans.PropertyValue;
import com.xcr.spring.beans.PropertyValues;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: xia
 * @Date: 2021/1/26 14:56
 * @Version: v1.0
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessorBeanFactory(DefaultListableBeanFactory factory) throws Exception {
        BeanDefinition person = factory.getBeanDefinition("person");
        PropertyValues propertyValues = person.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
