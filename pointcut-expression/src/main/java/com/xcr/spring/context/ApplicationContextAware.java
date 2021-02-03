package com.xcr.spring.context;

import com.xcr.spring.beans.factory.Aware;
import com.xcr.spring.beans.factory.BeanFactory;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:50
 * @Version: v1.0
 */
public interface ApplicationContextAware extends Aware{

    void setApplicationContext(ApplicationContext applicationContext) throws Exception;

}
