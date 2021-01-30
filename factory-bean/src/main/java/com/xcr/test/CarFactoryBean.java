package com.xcr.test;

import com.xcr.spring.beans.FactoryBean;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:51
 * @Version: v1.0
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
