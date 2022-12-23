package com.example.simplespringboottest.prac.practice.design_pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: SuperMarket
 * @Author: legen
 * @Date: 2020/12/15
 */
public class SuperMarket {
    private List<String>list = new ArrayList<>();

    public void add(String good){
        list.add(good);
    }
    public List<String> show(){
        return list;
    }
}
