package com.xcr.spring.beans.factory.support;

import com.xcr.spring.core.io.Resource;
import com.xcr.spring.core.io.ResourceLoader;

/**
 * @Author: xia
 * @Date: 2021/1/26 11:35
 * @Version: v1.0
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;

    void loadBeanDefinitions(String[] locations) throws Exception;

}
