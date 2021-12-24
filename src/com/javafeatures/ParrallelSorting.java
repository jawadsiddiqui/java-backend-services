package com.javafeatures;

import java.util.Arrays;

public class ParrallelSorting {
    public void sortExample(){
        int[] arr = {5,8,9,1,2,3,4,5};
        Arrays.parallelSort(arr);
    }
}
