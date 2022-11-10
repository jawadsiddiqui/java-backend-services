package com.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
       Consumer consumer1 =  (t) -> {
            System.out.println("Print off:"+ t);
        };

       List<Integer> list1 = Arrays.asList(1,2,3,4);
       list1.stream().forEach(consumer1);

       List<Integer> list2 = Arrays.asList(1,2,3,4,5);
       list2.stream().forEach((t) -> System.out.println("Creating inline consumer function:" + t));

    }
}
