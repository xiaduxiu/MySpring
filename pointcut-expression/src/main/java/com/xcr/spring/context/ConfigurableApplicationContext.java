package com.xcr.spring.context;


/**
 * @Author: xia
 * @Date: 2021/1/28 17:05
 * @Version: v1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws Exception;

    void close();

    void registerShutdownHook();

}
