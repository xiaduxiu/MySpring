package com.xcr.spring.context;

import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.core.io.ResourceLoader;

/**
 * @Author: xia
 * @Date: 2021/1/28 17:02
 * @Version: v1.0
 */
public interface ApplicationContext extends BeanFactory, ResourceLoader, ApplicationEventPublisher {

}
