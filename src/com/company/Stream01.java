package com.company;

import java.util.ArrayList;

public class Stream01 {
    public static void CheckStream(){

        ArrayList<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");
        myList.parallelStream().forEachOrdered(System.out::println);
        myList.stream().forEach(System.out::println);

    }
}
