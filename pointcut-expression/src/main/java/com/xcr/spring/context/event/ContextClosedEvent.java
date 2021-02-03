package com.xcr.spring.context.event;

import com.xcr.spring.context.ApplicationContext;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:57
 * @Version: v1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
