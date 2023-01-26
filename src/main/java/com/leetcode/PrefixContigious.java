package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixContigious {

    public static void main(String[] args) {
        PrefixContigious prefixContigious = new PrefixContigious();

        System.out.println(prefixContigious.solution("abbabba"));

    }
    public int solution(String S) {
        int maxProduct = 0;
        Map<String, Integer> prefixCount = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String prefix = S.substring(0, i + 1);


            String suffix = S.substring(S.length()-i, S.length());
            prefixCount.put(prefix, prefix.length());
            if(prefixCount.containsKey(suffix)){
                int product = prefixCount.get(suffix);

                maxProduct = Math.max(maxProduct, product);
                //System.out.println(maxProduct);
//
//                //System.out.println(suffix);
//                int count = suffix.length();
//                System.out.println(count);
            }
        }
        return maxProduct;

    }
}
