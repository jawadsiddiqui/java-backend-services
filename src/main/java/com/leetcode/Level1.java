package com.leetcode;

import java.util.Arrays;

public class Level1 {
    public static void main(String[] args) {
        int[] numbers = new int[] {1,2,3,4};

        for (int i=0; i<numbers.length; i++)
        {
            System.out.println(numbers[i]);

        }


        for (int j=numbers.length-1; j>=0; j--)
        {
            System.out.println(numbers[j]);

        }

        runningSum(numbers);

    }
    public static int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length; i++)
        {
            nums[i] += nums[i-1];

        }
        //Arrays.stream(nums).forEach(System.out::println);
        return nums;
    }
}
