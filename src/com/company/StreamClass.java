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
        list.add(7);
        list.add(9);

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

        System.out.println("Odd Values:");
        Stream<Integer> oddVal = list.stream().sorted().filter(n->n%2==1);
        oddVal.forEach(n-> System.out.print(n+" "));


        System.out.println("Filtering OddValues greater than 5:");
        oddVal = list.stream().sorted().filter(n->n%2==1).filter(n->n>5);
        oddVal.forEach(n-> System.out.print(n +" "));

        System.out.println("Parallel Stream forEachOrdered");
        ArrayList<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");

        // parallel stream supports parallel execution of stream operations
        myList.parallelStream().forEachOrdered(System.out::println);
        System.out.println("Stream forEach");
        myList.stream().forEach(System.out::println);

    }

    public static void reduceExamples()
    {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(2);


        //accumulator must satisfy three constrains
        // Stateless, Non-Interfaring, Associative

        Optional<Integer> streamReduce  = list.stream().reduce((a,b) -> a*b);
        if(streamReduce.isPresent())
            System.out.println("Product as optional:" + streamReduce.get());

        int product = list.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Product as Identity:" + product);

    }
}
