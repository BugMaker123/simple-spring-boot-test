package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static java.lang.Thread.sleep;

public class VolatileTestProBetter {
    private static volatile int count =0;

    public static void main(String[] args) {
        for(int i =0;i<10; i++){
            for (int j = 0; j < 1000; j++) {
                count++;
            }
        }
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
