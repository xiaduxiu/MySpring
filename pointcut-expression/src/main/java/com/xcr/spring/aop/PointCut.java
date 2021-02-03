package com.xcr.spring.aop;


/**
 * @Author: xia
 * @Date: 2021/2/3 17:00
 * @Version: v1.0
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
