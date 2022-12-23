package com.example.simplespringboottest.prac.first.mult.basemult;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BaseDataStruc {
    public static void main(String[] args) {
        // HashMap
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        // ConcurrentHashMap
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        // CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
    }
}
