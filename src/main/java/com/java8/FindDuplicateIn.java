package com.java8;

import java.util.Arrays;

public class FindDuplicateIn {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        boolean b = Arrays.stream(arr).anyMatch(u -> u == 3);

        System.out.println(b);
    }
}
