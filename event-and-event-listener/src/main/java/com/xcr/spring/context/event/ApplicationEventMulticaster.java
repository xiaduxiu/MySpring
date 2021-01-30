package com.xcr.spring.context.event;

import com.xcr.spring.context.ApplicationEvent;
import com.xcr.spring.context.ApplicationListener;

/**
 * @Author: xia
 * @Date: 2021/1/30 11:01
 * @Version: v1.0
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event) throws Exception;
}
