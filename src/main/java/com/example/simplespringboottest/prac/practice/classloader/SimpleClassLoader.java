package com.example.simplespringboottest.prac.practice.classloader;


import com.example.simplespringboottest.entity.User;

import java.lang.reflect.Field;

/**
 * @ ClassName: SimpleClassLoader
 * @Author: legen
 * @Date: 2021/3/24
 */
public class SimpleClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       Class clazz =  User.class;

       Class<?> forName = Class.forName("cn.com.trys.fantasy.entity.User");
        Field[] fields = forName.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }
        User user = (User)forName.newInstance();
        user.setPhone("1000086");
        System.out.println(user.getPhone());

        ClassLoader classLoader = forName.getClassLoader();
        Class<?> aClass = classLoader.loadClass("cn.com.trys.fantasy.entity.Children");
        for(Field field:fields){
            System.out.println(field.getName());
        }
    }
}
