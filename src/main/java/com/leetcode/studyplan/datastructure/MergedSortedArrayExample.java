package com.leetcode.studyplan.datastructure;

import java.util.Arrays;

public class MergedSortedArrayExample {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,0,0,0};
        int[] arr2 = new int[]{2,4,6};

        merge(arr, 4, arr2, 3);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //to set index
        m--; n--;
        int index = nums1.length - 1;

        while (index>=0)
        {

            if(m<0){
                nums1[index] = nums2[n--];

            } else if (n<0){
                nums1[index] = nums1[m--];
            } else {
                if(nums1[m]>nums2[n])
                {
                    nums1[index] = nums1[m--];
                } else {
                    nums1[index] = nums2[n--];

                }
            }



            Arrays.stream(nums1).forEach(System.out::println);
            System.out.println("\n iteration"+index);
            index--;
        }
    }
}
