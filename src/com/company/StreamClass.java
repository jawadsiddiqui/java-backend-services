package com.company;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;


// at a foundation we have BaseStream
// BaseStream is a generic Interface
public class StreamClass {
    public static void CheckStream(){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(0);

        System.out.println("Original List:" + list);

        Stream<Integer> myStream = list.stream();
        Optional<Integer> minValue = myStream.min(Integer::compare);
        //System.out.println(minValue);

        if(minValue.isPresent()){
            System.out.println("Min Value:"+minValue.get());
        }


        //terminal operation min() performed already
        //with below statement will create new stream
        myStream = list.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if(maxVal.isPresent()){
            System.out.println("Max Value:"+ maxVal.get());
        }

        //sorted stream operation
        Stream<Integer> sortedStream = list.stream().sorted();
        System.out.println("Sorted Stream");
        sortedStream.forEach(n-> System.out.println(n));

        System.out.println("Odd Values");
        Stream<Integer> oddVal = list.stream().sorted().filter(n->n%2==1);
        oddVal.forEach(n-> System.out.println(n));

        System.out.println("Parallel Stream forEachOrdered");
        ArrayList<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");

        // parallel stream supports parallel execution of stream operations
        myList.parallelStream().forEachOrdered(System.out::println);
        System.out.println("Stream forEach");
        myList.stream().forEach(System.out::println);

    }
}
