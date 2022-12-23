package com.example.simplespringboottest.prac.practice.demos;



import com.example.simplespringboottest.prac.worktools.EmpInfoQueryRespDTO;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

/**
 * 实体类转成数据库字段
 * @ ClassName: ClassAssiliss
 * @Author: legen
 * @Date: 2020/10/30
 */
public class ClassAnalysis {
    public static void main(String[] args) {
        Class clazz = EmpInfoQueryRespDTO.class;
        Field[] fields = clazz.getDeclaredFields();
        TypeVariable[] typeParameters = clazz.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            System.out.println(typeParameters[i].getName());
        }
        System.out.println(fields[0].getType().getSimpleName());
        System.out.println(fields[0].getType().getName());
    }
}
