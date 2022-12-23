package com.example.simplespringboottest.prac.design_pattern.factory.SimpleFactory;

public class IphoneFactory extends PhoneFactory {

    @Override
    void receiveOrder() {
        System.out.println("苹果手机收到订单");
    }

    @Override
    void createPhone() {
        System.out.println("苹果手机生产完成");
    }
}
