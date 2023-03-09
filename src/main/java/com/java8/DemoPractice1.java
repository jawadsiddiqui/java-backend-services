package com.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DemoPractice1 {
    public static void main(String[] args) {
        List<String> list =  Arrays.asList("apple","awapple","chapple");

        list.stream().filter(t-> t.startsWith("a"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        CompletableFuture.supplyAsync(()-> "Hello")
                .thenApply(s-> s + " World")
                .thenAccept(System.out::println)
                .join();


        List<List<String>> myList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "pear"),
                Arrays.asList("grape", "pineapple")
        );

        myList.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
