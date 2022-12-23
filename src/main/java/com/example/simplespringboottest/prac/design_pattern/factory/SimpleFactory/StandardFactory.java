package com.example.simplespringboottest.prac.design_pattern.factory.SimpleFactory;

public class StandardFactory {
    PhoneFactory createPhone(String phoneName){
        if(phoneName.equals("mi")){
            return new MiPhoneFactory();
        }else if(phoneName.equals("iphone")){
            return new IphoneFactory();
        }else {
            throw new RuntimeException("no this phone");
        }
    }
}
