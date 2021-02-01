package com.xcr.spring.context.event;

import com.xcr.spring.beans.factory.BeanFactory;
import com.xcr.spring.context.ApplicationEvent;
import com.xcr.spring.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: xia
 * @Date: 2021/1/30 15:49
 * @Version: v1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) throws Exception {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) throws Exception {
        for (ApplicationListener<ApplicationEvent> applicationListener : getApplicationListeners()) {
            if (supportsEvent(applicationListener, event)) {
                applicationListener.onApplicationEvent(event);
            }
        }
    }

    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) throws Exception {
        Class<?> eventClassName;
        Type type = applicationListener.getClass().getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        String typeName = actualTypeArgument.getTypeName();
        try {
            eventClassName = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new Exception("wrong event class name: " + typeName);
        }
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
