package com.example.simplespringboottest.springtests;

import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.stereotype.Component;

@Component
public class AutoConfigTest {

    public void test(){
        System.out.println("test");
    }
}
