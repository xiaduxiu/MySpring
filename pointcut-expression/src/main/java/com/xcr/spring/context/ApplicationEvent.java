package com.xcr.spring.context;

import java.util.EventObject;

/**
 * @Author: xia
 * @Date: 2021/1/30 10:53
 * @Version: v1.0
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
