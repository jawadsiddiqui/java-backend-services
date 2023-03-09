package com.problems;

import java.util.Arrays;
import java.util.Comparator;

public class SortPairs {
    public static void main(String[] args) {
        int [][] pairs  = {{1, 3}, {9,4}, {3,1}, {4,3}, {4,9}};
        // Sort the pairs based on the first element in each pair
        Arrays.sort(pairs, Comparator.comparingInt(a->a[0]));


        Arrays.stream(pairs).forEach(a-> System.out.println(a[0] +","+ a[1]));


        int [][] pairs2  = {{1, 3, 3}, {9,4, 3}, {3,1, 3}, {4,3, 4}, {4,9, 4}};
        Arrays.sort(pairs2, Comparator.comparingInt(a->a[0]));
        Arrays.stream(pairs2).forEach(a-> System.out.println(a[0] +","+ a[1] +","+  a[2]));


    }
}
