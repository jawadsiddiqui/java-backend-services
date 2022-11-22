package com;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTesting {

    public static void main(String[] args) {
        HashMap<String , String> hashMap = new HashMap<>();
        hashMap.put("e1","String1");

        //hashMap.put("e1", "yes");
        

        System.out.println(hashMap);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(123, "String");

        //concurrentHashMap.put(123, "yes");

        concurrentHashMap.putIfAbsent(123, "yes");

        System.out.println(concurrentHashMap);

    }
}
