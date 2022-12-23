package com.example.simplespringboottest.prac.worktools.bo;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Class<PcOrganizationInfo> res = PcOrganizationInfo.class;
        Field[] fields = res.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("'"+fields[i].getName()+"'"+":{'type':'"+fields[i].getType().getName()+"'}");
        }
    }
}
