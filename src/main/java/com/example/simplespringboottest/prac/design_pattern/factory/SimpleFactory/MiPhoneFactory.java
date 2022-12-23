package com.example.simplespringboottest.prac.design_pattern.factory.SimpleFactory;

public class MiPhoneFactory extends PhoneFactory {

    @Override
    void receiveOrder() {
        System.out.println("小米手机收到订单");
    }

    @Override
    void createPhone() {
        System.out.println("小米手机生产完成");
    }
}
