package com.example.simplespringboottest.prac.design_pattern.strategy;

public class OperationDiv extends BaseStrategy{
    @Override
    public int doOperation(int a, int b) {
       if (b == 0) {
           throw new RuntimeException("除数不能为0");
       }
        return a/b;
    }
}
