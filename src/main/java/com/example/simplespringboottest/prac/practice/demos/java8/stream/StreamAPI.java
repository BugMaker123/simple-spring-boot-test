package com.example.simplespringboottest.prac.practice.demos.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ ClassName: StreamAPI
 * @Author: legen
 * @Date: 2021/2/1
 */
public class StreamAPI {
    public static void main(String[] args) {
    // 1.数据分组
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 7, 1,1,1,1);
        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(Integer::intValue));
        map.forEach((key,value)-> System.out.println(key+","+map.get(key)));
        System.out.println("============================");
        map.forEach((key,value)-> System.out.println(key+","+value));

        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(1.5));
    }
}
