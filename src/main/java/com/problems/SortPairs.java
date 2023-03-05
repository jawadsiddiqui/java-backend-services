package com.problems;

import java.util.Arrays;
import java.util.Comparator;

public class SortPairs {
    public static void main(String[] args) {
        int [][] pairs  = {{1, 3}, {9,4}, {3,1}, {4,3}, {4,9}};
        // Sort the pairs based on the first element in each pair
        Arrays.sort(pairs, Comparator.comparingInt(a->a[0]));


        Arrays.stream(pairs).forEach(a-> System.out.println(a[0] +" , "+ a[1]));
    }
}
