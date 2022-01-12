package com.problems;

import java.util.ArrayList;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {};
        double median = findMedianSortedArrays(num1, num2);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median =0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            arrayList.add(nums2[i]);
        }
        return median;
    }
}
