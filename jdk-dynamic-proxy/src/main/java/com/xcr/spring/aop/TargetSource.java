package com.xcr.spring.aop;

/**
 * @Author: xia
 * @Date: 2021/2/3 17:24
 * @Version: v1.0
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTagetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }


}
