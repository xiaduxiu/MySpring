package com.xcr.test.event;

import com.xcr.spring.context.ApplicationListener;
import com.xcr.spring.context.event.ContextClosedEvent;

/**
 * @Author: xia
 * @Date: 2021/1/30 16:15
 * @Version: v1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {


    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(this.getClass().getSimpleName());
    }
}
