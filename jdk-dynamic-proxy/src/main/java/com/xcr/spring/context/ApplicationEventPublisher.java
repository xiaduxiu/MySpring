package com.xcr.spring.context;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:58
 * @Version: v1.0
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event) throws Exception;
}
