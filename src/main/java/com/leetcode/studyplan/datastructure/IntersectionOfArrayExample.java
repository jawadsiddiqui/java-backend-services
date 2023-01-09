package com.leetcode.studyplan.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfArrayExample {
    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};


        int[] intersect = IntersectionOfArrayExample.intersect(num1, num2);

        Arrays.stream(intersect).forEach(System.out::println);

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else
                map.put(num, 1);
        }

        ArrayList<Integer> list =new ArrayList<>();

        for(int num: nums2){
            if(map.containsKey(num) && map.get(num)> 0){
                list.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
