package com.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("three", 3);
        map.put("one", 1);
        map.put("two", 2);


        map.forEach((t, v) -> System.out.println(t+","+v));


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("three", 3);
        map1.put("one", 1);
        map1.put("two", 2);

        map1.forEach((t, v) -> System.out.println(t+","+v));

    }
}
