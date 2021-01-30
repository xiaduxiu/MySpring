package com.xcr.spring.context.event;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:57
 * @Version: v1.0
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
