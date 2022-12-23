package com.example.simplespringboottest.prac.practice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * spi-加载  service provider interface
 * 系统里抽象的各个模块，往往有很多不同的实现方案，在面向的对象的设计里，一般推荐模块之间基于接口编程，模块之间不对实现类进行硬编码。
 * 一旦代码里涉及具体的实现类，就违反了可拔插的原则，如果需要替换一种实现，就需要修改代码。为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制。 java spi就是提供这样的一个机制：为某个接口寻找服务实现的机制
 * 详情见(多模块下的spi机制)
 * https://www.yuque.com/akisaya/blogs/upim1i
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/2/2
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = load.iterator();
        while(iterator.hasNext()){
            Animal animal = iterator.next();
            System.out.println(animal.getClass()+"==="+animal.voice());
        }
    }
}
