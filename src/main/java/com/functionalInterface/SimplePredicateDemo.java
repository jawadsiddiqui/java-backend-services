package com.functionalInterface;

import java.util.function.Predicate;

public class SimplePredicateDemo implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        if(integer%2==0)
        {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = new SimplePredicateDemo();
        System.out.println(predicate.test(10));
    }
}
