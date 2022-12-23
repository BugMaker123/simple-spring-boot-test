package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

import java.util.Hashtable;

/**
 * @ ClassName: Cache
 * @Author: legen
 * @Date: 2020/12/16
 */
public class Cache{
    private static Hashtable<String, Parent>parentMap
            = new Hashtable<>();

    public static Parent getShape(String name) throws CloneNotSupportedException {
        Parent cachedParent = parentMap.get(name);
        return (Parent) cachedParent.clone();
    }
    public static void loadCache(){
        ChildrenA childrenA = new ChildrenA();
        parentMap.put("child A",childrenA);
        ChildrenB childrenB = new ChildrenB();
        parentMap.put("child B",childrenB);
        ChildrenC childrenC = new ChildrenC();
        parentMap.put("child C",childrenC);
    }
}
