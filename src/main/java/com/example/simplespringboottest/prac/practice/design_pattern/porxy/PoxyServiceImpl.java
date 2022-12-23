package com.example.simplespringboottest.prac.practice.design_pattern.porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ ClassName: PoxyServiceImpl
 * @Author: legen
 * @Date: 2020/12/10
 */
public class PoxyServiceImpl implements InvocationHandler {
    private Object object;

    public PoxyServiceImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,null);
        System.out.println("finish proxy");
        return null;
    }
}
