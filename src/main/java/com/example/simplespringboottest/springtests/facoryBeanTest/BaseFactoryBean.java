package com.example.simplespringboottest.springtests.facoryBeanTest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("baseFactoryBean")
public class BaseFactoryBean implements FactoryBean<Base> {

    @Override
    public Base getObject() throws Exception {
        Base base = new Base();
        base.setName("baseFactoryBean");
        base.setAge(18);
        base.setProfession("factoryBean");
        // 处理复杂业务逻辑---start
        // ................
        // 处理复杂业务逻辑---end
        return base;
    }

    @Override
    public Class<?> getObjectType() {
        return Base.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
