package com.xcr.spring.aop;

import java.lang.reflect.Method;

/**
 * @Author: xia
 * @Date: 2021/2/3 16:59
 * @Version: v1.0
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
