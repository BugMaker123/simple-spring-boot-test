package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: Market
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Market {
    private List<Good> goodList = new ArrayList<>();

    public void addGood(Good good){
        goodList.add(good);
    }

    public List<Good> getGoodList(){
        return goodList;
    }
}
