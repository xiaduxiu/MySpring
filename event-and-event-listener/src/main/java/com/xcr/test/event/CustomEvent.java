package com.xcr.test.event;

import com.xcr.spring.context.ApplicationEvent;
import com.xcr.spring.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xia
 * @Date: 2021/1/30 16:13
 * @Version: v1.0
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(ClassPathXmlApplicationContext source) {
        super(source);
    }
}
