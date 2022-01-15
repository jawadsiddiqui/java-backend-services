package com.javalibrary;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Spliterator Iterates over collection, streams and array
 * Split and iterate
 * Iterate 1-by-1 or in bulk
 *
 */
public class SpliteratorClass {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("ccc");

        //Iterate over collections
        Spliterator<String> spliterator = list.spliterator();
        /*
        * tryAdvance() perform an action on next element and then advances next iterator.
        */
        while (spliterator.tryAdvance( (n) -> System.out.println(n)));

        //Iterate over Streams
        Stream<String> stream = list.stream();
        Spliterator<String> spliterator1 = stream.spliterator();
        while (spliterator1.tryAdvance((n) -> System.out.println(n)));

        spliterator.forEachRemaining((n)-> System.out.println(n));

        
    }
}
