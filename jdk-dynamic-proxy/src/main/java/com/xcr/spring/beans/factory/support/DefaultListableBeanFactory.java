package com.xcr.spring.beans.factory.support;

import com.xcr.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xia
 * @Date: 2021/1/15 16:41
 * @Version: v1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanDefinitionMap.get(beanName);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String s : beanDefinitionMap.keySet()) {
            getBean(s);
        }
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return ((T) getBean(name));
    }

    @Override
    public void addSingletonBean(String beanName, Object singleObject) {
        super.addSingletonBean(beanName, singleObject);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception {
        Map<String, T> result = new HashMap<>();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                T bean = null;
                try {
                    bean = (T) getBean(beanName);
                } catch (Exception e) {
                    throw new Exception("getBeansOfType error");
                }
                result.put(beanName, bean);
            }
        }
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        Set<String> beanNames = beanDefinitionMap.keySet();
        return beanNames.toArray(new String[beanNames.size()]);
    }
}
