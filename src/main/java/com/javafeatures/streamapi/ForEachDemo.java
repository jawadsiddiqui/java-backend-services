package com.javafeatures.streamapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {
    public static void main(String[] args) {
        String s = "a,b,v,c,d";
        List<String> list = Arrays.asList(s.split(","));

        //traditional way
        for(String string: list)
        {
            System.out.println(string);
        }

        list.stream().forEach(t-> System.out.println("Stream foreach:"+t));


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");

        map.forEach((key,value) -> System.out.println(key + ":"+value));
        map.entrySet().forEach(t-> System.out.println(t));
    }
}
