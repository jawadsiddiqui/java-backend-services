package com.freecodecamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSymmetricDiff {

    public static void main(String[] args) {
        int[] m = new int[]{1, 2, 3};
        int[] n = new int[]{3,4,5};


        // 1, 2, 3
        // 3, 4, 5

        //1, 2, 4, 5

        symDiff(m,n);
    }

    public static void symDiff(int[] m, int[] n){
        for (int i = 0; i <  m.length; i++) {
            for (int x=0; x<n.length; x++){
                if (m[i] != n[x]) {

                }
            }
        }

    }
}
