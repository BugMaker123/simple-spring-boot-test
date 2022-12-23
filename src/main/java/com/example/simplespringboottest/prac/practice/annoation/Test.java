package com.example.simplespringboottest.prac.practice.annoation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/1/25
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(2);
        map.put("1","Tom");
        map.put("2","Tommy");
        map.put("3","Jam");
        for(String key: map.keySet()){
            System.out.println(key);
        }

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
