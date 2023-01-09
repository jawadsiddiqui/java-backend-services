package com.leetcode.studyplan.datastructure;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainDuplicateExample {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

    }

    //bruteforce strategy
    public static boolean containsDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int y=i+1; y<nums.length; y++){
                if(nums[i]==nums[y]){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean containDuplicateUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            } else
            {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
