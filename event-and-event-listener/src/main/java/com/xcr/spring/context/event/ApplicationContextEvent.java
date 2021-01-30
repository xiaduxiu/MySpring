package com.xcr.spring.context.event;

import com.xcr.spring.context.ApplicationContext;
import com.xcr.spring.context.ApplicationEvent;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:54
 * @Version: v1.0
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext)getSource();
    }
}
