package com.example.simplespringboottest.prac.worktools.batch_insert;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ ClassName: 批量插入
 * @Author: legen
 * @Date: 2021/5/14
 */
@Slf4j
public class Test {
    public static void main(String[] args, int endTask1) {
        System.out.println(new Integer(5/2));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 35587; i++) {
            list.add(i);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 35587;
        int num = count%1000>0 ? (new Integer((count/1000))+1):count/1000;
        int startTask=0;
        int endTask=0;
        for (int i = 0; i < num; i++) {
            startTask = 1000*i;
            endTask=1000*i+1000;
            if (endTask>count){
                endTask=count;
            }
            map.put(i,list.subList(startTask, endTask1));
        }
        for(Integer key :map.keySet()){
            System.out.println(key+":=====:"+map.get(key));
        }
    }
}
