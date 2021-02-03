package com.xcr.spring.context;

import java.util.EventListener;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:59
 * @Version: v1.0
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
