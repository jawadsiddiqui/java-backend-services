package com.leetcode.studyplan.datastructure;

public class MaxContegiousArray {

    public static void main(String[] args) {

        System.out.println(Math.max(15,10));
        int[] arr = new int[]{-1};
        int max_positive =arr[0], max_sum=arr[0];

        for (int i=1; i<arr.length; i++){
            max_positive = Math.max(arr[i], max_positive+arr[i]);
            max_sum = Math.max(max_sum, max_positive);
        }

        System.out.println(max_sum);
    }
}
