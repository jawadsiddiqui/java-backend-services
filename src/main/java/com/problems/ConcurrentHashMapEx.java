package com.problems;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("apple", 3);
        map.put("banana", 3);
        System.out.println(map);;

        int appleValue = map.get("apple");
        int value2 = map.getOrDefault("pear",0);


        System.out.println(appleValue);
        System.out.println(value2);

        map.computeIfPresent("apple", (k,v) -> v=5);

        System.out.println(map.get("apple"));


        map.computeIfAbsent("pear", k->4);
        System.out.println(map.get("pear"));
    }
}
