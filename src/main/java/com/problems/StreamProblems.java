package com.problems;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamProblems {

    public static boolean isPrime(int number) {
        IntPredicate isDivisible = index -> number %  index ==0;
        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
    }
    public static void main(String[] args) {
        System.out.println(isPrime(3));
    }
}
