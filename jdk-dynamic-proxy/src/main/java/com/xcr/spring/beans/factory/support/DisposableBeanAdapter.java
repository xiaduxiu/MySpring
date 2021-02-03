package com.xcr.spring.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.config.DisposableBean;

import java.lang.reflect.Method;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:20
 * @Version: v1.0
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if (destroyMethod == null) {
                throw new Exception("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
