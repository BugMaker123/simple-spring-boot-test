package com.example.simplespringboottest.springtests.facoryBeanTest;

import org.springframework.beans.factory.FactoryBean;

public class AlgorithmFactoryBean implements FactoryBean<AlgorithmService> {
    //算法类型：MD5 | AES
    private String algorithmType;

    @Override
    public AlgorithmService getObject() throws Exception {
        if("MD5".equals(algorithmType)){
            return new  MD5algorithmServiceImpl();
        }
        if("AES".equals(algorithmType)){
            return new AESAlgorithmServiceImpl();
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return AlgorithmService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }
}
