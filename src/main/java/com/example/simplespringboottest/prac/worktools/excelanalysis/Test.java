package com.example.simplespringboottest.prac.worktools.excelanalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/4/20
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.toString());
        String s = list.toString();
        String r1 = s.replace("[", "(");
        String r2 = r1.replace("]", ")");
        System.out.println(r2);
    }
}
