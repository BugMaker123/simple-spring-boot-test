package com.example.simplespringboottest.prac.practice.demos.java8.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/2/1
 */
public class Test {
    public static void main(String[] args) {
        // 1.下面这几种都是等价的,
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
        System.out.println("===========");
        Arrays.asList("a", "b", "d").forEach(m -> System.out.println(m));
        System.out.println("===========");
        List<String> list = Arrays.asList("a", "b", "d");
        for (String e : list) {
            System.out.println(e);
        }
        System.out.println("===========");
        // 2. 如果语句块比较复杂，使用 {} 包起来
        Arrays.asList("a", "b", "d").forEach(e -> {
            String m = "9420" + e;
            System.out.println(m);
        });

        // 3.Lambda 本质上是匿名内部类的改装，所以它使用到的变量都会隐式的转成 final 的

        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                e -> System.out.print(e + separator));
        //等价于
        final String separator2 = ",";
        Arrays.asList("a", "b", "d").forEach(
                e -> System.out.print(e + separator2));

        // 4.Lambda 的返回值和参数类型由编译器推理得出，不需要显示定义，如果只有一行代码可以不写 return 语句
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        //等价于
        List<String> list2 = Arrays.asList("a", "b", "c");
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list2.forEach(e-> System.out.println(e));
    }
}
