package com.example.simplespringboottest.prac.practice.design_pattern.porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Test {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        InvocationHandler poxyService = new PoxyServiceImpl(service);
        // InvocationHandler类型要teb注意
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(),poxyService);
        userService.singSong();
    }
}
