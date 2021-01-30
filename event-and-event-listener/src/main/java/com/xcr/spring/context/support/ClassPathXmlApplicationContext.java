package com.xcr.spring.context.support;

import com.xcr.spring.context.ApplicationEvent;

/**
 * @Author: xia
 * @Date: 2021/1/28 18:02
 * @Version: v1.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws Exception {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
