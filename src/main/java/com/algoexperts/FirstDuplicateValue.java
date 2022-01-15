package com.algoexperts;

import java.util.HashSet;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(arr));
    }

    /**
     * Simple solution using Brut force
     * O(n^2) time | O(1) space
     *
     * @param array
     * @return
     */
    public static int firstDuplicateValue(int[] array) {
        int minimumIndex = array.length;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    minimumIndex = Math.min(minimumIndex, j);
                }
            }
        }

        if (minimumIndex == array.length) return -1;

        return array[minimumIndex];
    }
}