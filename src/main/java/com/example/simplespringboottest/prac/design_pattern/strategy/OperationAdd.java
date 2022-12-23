package com.example.simplespringboottest.prac.design_pattern.strategy;

public class OperationAdd extends BaseStrategy{
    @Override
    public int doOperation(int a, int b) {
        return a+b ;
    }
}
