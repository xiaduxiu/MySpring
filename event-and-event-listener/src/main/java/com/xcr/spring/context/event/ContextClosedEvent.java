package com.xcr.spring.context.event;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:57
 * @Version: v1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
