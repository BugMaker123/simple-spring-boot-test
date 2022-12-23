package com.example.simplespringboottest.prac.worktools;

import com.example.simplespringboottest.prac.worktools.entity.EmpInfoNotCompleted;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/1/19
 */
public class 实体类转BaseResultMap {
    public static void main(String[] args) {
        Class<EmpInfoNotCompleted> empInfoClass = EmpInfoNotCompleted.class;
        Field[] fields = empInfoClass.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            List<String> chList = new ArrayList<>();
            char[] chars = fields[i].getName().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if ((chars[j] >= 'A') && (chars[j] <= 'Z')) {
                    chars[j] = (char) (chars[j] + 32);
                    chList.add("_");
                }
                chList.add(String.valueOf(chars[j]));
            }
            String str = "";
            for (int j = 0; j < chList.size(); j++) {
                str = str + chList.get(j);
            }
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("<result column=\""+list.get(i)+"\""+" "+"property = \""+fields[i].getName()+"\"/>");
        }
    }
}


