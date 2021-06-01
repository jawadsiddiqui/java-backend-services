package com.company;

import java.util.ArrayList;


// at a foundation we have BaseStream
// BaseStream is a generic Interface
public class Stream01 {
    public static void CheckStream(){

        ArrayList<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");

        // parallel stream supports parallel execution of stream operations
        myList.parallelStream().forEachOrdered(System.out::println);
        myList.stream().forEach(System.out::println);

    }
}
