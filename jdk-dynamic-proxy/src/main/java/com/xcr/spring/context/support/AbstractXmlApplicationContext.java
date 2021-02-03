package com.xcr.spring.context.support;

import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import com.xcr.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: xia
 * @Date: 2021/1/28 17:52
 * @Version: v1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
