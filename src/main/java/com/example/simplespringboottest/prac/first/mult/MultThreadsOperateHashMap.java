package com.example.simplespringboottest.prac.first.mult;

import lombok.Data;

import java.util.HashMap;

@Data
public class MultThreadsOperateHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("10", "10");
        map.put("11", "11");
   /*     for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put("23", "value");
            }, "t" + i).start();
        }*/
        for (String key : map.values()) {
            System.out.println(map.get(key));
        }


    }
}
