package com.xcr.test.event;

import com.xcr.spring.context.ApplicationListener;
import com.xcr.spring.context.event.ContextRefreshedEvent;

/**
 * @Author: xia
 * @Date: 2021/1/30 16:14
 * @Version: v1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
