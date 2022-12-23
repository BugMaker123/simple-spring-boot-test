package com.example.simplespringboottest.prac.design_pattern.factory.SimpleFactory;

public class Test {
    public static void main(String[] args) {
        StandardFactory standardFactory = new StandardFactory();
        PhoneFactory mi = standardFactory.createPhone("mi");
        mi.receiveOrder();
        mi.createPhone();

        PhoneFactory iphone = standardFactory.createPhone("iphone");
        iphone.receiveOrder();
        iphone.createPhone();

    }
}
