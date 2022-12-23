package com.example.simplespringboottest.prac.design_pattern.strategy;

public class Context {
    private BaseStrategy strategy;

    public Context(BaseStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
