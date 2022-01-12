package com.problems;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        Random rand = new Random();
        for (int i=0; i<array.length; i++){
            int tempIndex = rand.nextInt(array.length);
            int temp = array[tempIndex];
            array[tempIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
