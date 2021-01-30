package com.xcr.test;

/**
 * @Author: xia
 * @Date: 2021/1/26 14:20
 * @Version: v1.0
 */
public class Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
