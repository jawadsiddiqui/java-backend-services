package com.problems;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] sorted = bubbleSort(new int[]{5, 3, 2, 2, 1, 2, 3, 4});
        System.out.println(Arrays.toString(sorted));
    }

    /**
     * O(n^2) time | O(1) space
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if (array.length==0) return new int[] {};

        int i=0;
        while (i< array.length)
        {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j])
                {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            i++;
        }
        return array;
    }
}