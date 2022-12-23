package com.example.simplespringboottest.springtests.facoryBeanTest;

public class AESAlgorithmServiceImpl implements AlgorithmService {
    @Override
    public void encrypt() {
        System.out.println("AES加密");
    }
}
