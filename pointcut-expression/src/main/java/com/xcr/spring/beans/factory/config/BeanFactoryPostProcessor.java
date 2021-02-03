package com.xcr.spring.beans.factory.config;

import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: xia
 * @Date: 2021/1/26 14:53
 * @Version: v1.0
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有beandefinition 加载完成后，但是bean还未实例化之前，修改beandefinition的属性值
     * @param factory
     * @throws Exception
     */
    void postProcessorBeanFactory(DefaultListableBeanFactory factory) throws Exception;
}
