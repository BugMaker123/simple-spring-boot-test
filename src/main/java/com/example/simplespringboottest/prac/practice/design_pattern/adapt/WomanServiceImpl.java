package com.example.simplespringboottest.prac.practice.design_pattern.adapt;

/**
 * @ ClassName: ManServiceImpl
 * @Author: legen
 * @Date: 2020/12/10
 */
public class WomanServiceImpl implements HumanService{
    @Override
    public void eatFood() {
        HumanService service = new ManServiceImpl();
        service.eatFood();
    }
}
