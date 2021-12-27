package com.javafeatures;

import java.util.Arrays;

/**
 * Array.parallelSort() - JSR 166 Fork/Join Parallelism
 * Overloaded with all primitive data types and compareable objects.
 */
public class ParrallelSorting {
    public void sortExample(){
        int[] arr = {5,8,9,1,2,3,4,5};
        Arrays.parallelSort(arr);
    }
}
