package com.xcr.spring.beans.factory.config;

import com.xcr.spring.beans.PropertyValues;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:31
 * @Version: v1.0
 */
public class BeanDefinition {

    private static final String SCOPE_SINGLETON = "singleton";
    private static final String SCOPE_PROTOTYPE = "prototype";
    private Class beanClass;
    private String className;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;
    private String scope = SCOPE_SINGLETON;
    private boolean singleton = true;
    private boolean prototype = false;


    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null? new PropertyValues() : propertyValues;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isPrototype(){
        return this.prototype;
    }

    public boolean isSingleton(){
        return this.singleton;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
