package com.javalibrary;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SplitAndIterate {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("ccc");
        list.add("ccc2");
        list.add("ccc3");
        list.add("ccc4");

        Stream<String> stream = list.stream();
        Spliterator<String> spliterator = stream.spliterator();

        Spliterator<String> spliterator1 = spliterator.trySplit();

        if(null!=spliterator1){
            System.out.println("Splited2");
            spliterator1.forEachRemaining((n)-> System.out.println(n));
        }
        System.out.println("split 1");
        spliterator.forEachRemaining((n)-> System.out.println(n));
    }
}
