package com.example.simplespringboottest.prac.worktools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: 实体类字段转数据库字段
 * @Author: legen
 * @Date: 2020/12/28
 */
public class 实体类字段转数据库字段 {
    public static void main(String[] args) {
        Class clazz = SysMonthRank.class;
        Field[] fields = clazz.getDeclaredFields();
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
        String simpleName = null;
        for (int i = 0; i < list.size(); i++) {
            simpleName = fields[i].getType().getSimpleName();
            switch (simpleName){
                case "String":
                    simpleName = "varchar";
                    break;
                case "Integer":
                    simpleName = "int";
                    break;
                case "Date":
                    simpleName = "datetime";
                    break;
                case "Long":
                    simpleName = "bigInt";
                    break;
                default:
                    break;
            }
            System.out.println("`"+list.get(i)+"` "+simpleName+"(),");
        }
    }
}