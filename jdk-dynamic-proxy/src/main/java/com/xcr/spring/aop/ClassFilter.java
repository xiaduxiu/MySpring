package com.xcr.spring.aop;

/**
 * @Author: xia
 * @Date: 2021/2/3 16:58
 * @Version: v1.0
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
