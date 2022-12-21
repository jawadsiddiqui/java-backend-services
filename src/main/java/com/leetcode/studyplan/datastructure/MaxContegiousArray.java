package com.leetcode.studyplan.datastructure;

import java.util.Arrays;

public class MaxContegiousArray {

    public static void main(String[] args) {

        int[] arr = new int[]{-1,-5,2,3,-1,4,-9,7};
        int curr_max =arr[0], max_sum=arr[0];


        for(int i=1;i<arr.length;i++){
            curr_max  = Math.max(arr[i], curr_max+arr[i]);
            System.out.println("curr_max:"+curr_max);
            max_sum = Math.max(max_sum, curr_max);
            System.out.println("max_sum:"+max_sum);

        }
        System.out.println(max_sum);

        System.out.println("skip() and limit usage");

        Arrays.stream(arr).skip(1).limit(10).forEach(System.out::println);
    }
}
