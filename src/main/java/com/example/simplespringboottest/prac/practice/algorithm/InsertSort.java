package com.example.simplespringboottest.prac.practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName: InsertSort
 * @Author: legen
 * @Date: 2020/12/11
 */
public class InsertSort {
    static Integer []arr={3,55,58,2,12,569};
    public static void main(String[] args) {
        Integer temp = 0;
        List<Integer> list = Arrays.asList(arr);
        List<Integer> resultList = new ArrayList<>();
        resultList.set(0,list.get(0));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)<resultList.get(0)){
                for (int  j = resultList.size();j >= 0; j++) {
                    temp=resultList.get(i);
                    resultList.set(j,list.get(i));

                }
            }
        }
    }
}
