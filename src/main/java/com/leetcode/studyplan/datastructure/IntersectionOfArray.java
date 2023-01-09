package com.leetcode.studyplan.datastructure;

import com.functionalInterface.PredicateDemo;
import com.java8.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};


        int[] intersect = IntersectionOfArray.intersect(num1, num2);

        Arrays.stream(intersect).forEach(System.out::println);

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums1)

            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);


        List<Integer> list = new ArrayList<>();


        //check frequency count
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0)
            {
                list.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
