package com.xcr.test.event;

import com.xcr.spring.context.ApplicationListener;

/**
 * @Author: xia
 * @Date: 2021/1/30 16:13
 * @Version: v1.0
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
