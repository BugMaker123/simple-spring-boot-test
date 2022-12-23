package com.example.simplespringboottest.prac.practice.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ ClassName: StringTest
 * @Author: legen
 * @Date: 2020/12/11
 */
public class StringTest {
    public static void main(String[] args) {
        String s = new String("10255");

        System.out.println(s.hashCode());
        StringBuffer stringBuffer = new StringBuffer(s);

        System.out.println(s.hashCode());
        stringBuffer.append("s");
        System.out.println(s.hashCode());

        String str="1";
        System.out.println(str.hashCode());
        str="2";
        System.out.println(str.hashCode());

        String a = "a";
        System.out.println(a.toUpperCase());
        char c = 'c';
        c-=32;
        System.out.println(c);

    }
}
class Test{
    public static void main(String[] args) {
       final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // string的不可变性是在地址不可变

        List<Integer> list1 = (List<Integer>) Collections.unmodifiableCollection( list);
        list1.add(5);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        //ServiceLoader.load()
    }
}

