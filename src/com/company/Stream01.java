package com.company;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;


// at a foundation we have BaseStream
// BaseStream is a generic Interface
public class Stream01 {
    public static void CheckStream(){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        System.out.println("Original List" + list);

        Stream<Integer> myStream = list.stream();
        Optional<Integer> minValue = myStream.min(Integer::compare);
        //System.out.println(minValue);

        if(minValue.isPresent()){
            System.out.println(minValue.get());
        }


        ArrayList<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");

        // parallel stream supports parallel execution of stream operations
        myList.parallelStream().forEachOrdered(System.out::println);

        myList.stream().forEach(System.out::println);

    }
}
