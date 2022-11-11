package com.leetcode;

public class RemoveAdjDuplicate {

    public static final String STRING_DUPLICATE = "abccda";

    public static void main(String[] args) {
        System.out.println(removeDuplicates(STRING_DUPLICATE));
    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if (sb.length() > 0 && sb.charAt(sb.length()-1) == c) {
                sb.deleteCharAt(sb.length()-1);
            } else {sb.append(c);}
        }

        return sb.toString();
    }
}
