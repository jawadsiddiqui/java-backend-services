package com.leetcode.studyplan.datastructure;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumExample {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4};
        int target = 5;

        int[] extracted = extracted(arr, target);
        Arrays.stream(extracted).forEach(System.out::println);
    }

    private static int[] extracted(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //key = 2, 3 , 4

        for (int i = 0; i< arr.length; i++){
            int remaining = target - arr[i];
            if(map.containsKey(remaining))
            {
                return new int[] {  map.get(remaining) , i};
            }

            map.put(arr[i], i);

        }

        return new int[] {};
    }

}
