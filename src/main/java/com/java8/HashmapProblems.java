package com.java8;

import java.util.HashMap;

public class HashmapProblems {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, -1};
        int target = 6;

        coundPairs(nums, target);

    }

    private static int coundPairs(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;

        for(int num: nums){
            int complement = target - num;
            count += map.getOrDefault(complement, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        System.out.println(count);

        return count;
    }


}
