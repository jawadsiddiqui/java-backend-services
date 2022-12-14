package com.java8;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//JPMorgan Question
public class FrequencyOfEachChar {
    public static void main(String[] args) {
        //using stream find frequency of each character in given string
        String input = "Jawwad";

        Map<String, Long> collect =   Arrays.stream(input.split("")).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        System.out.println(collect);
    }
}
