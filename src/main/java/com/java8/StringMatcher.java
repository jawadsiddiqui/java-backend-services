package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatcher {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        String inputStr = "test";
        List<String> lists = Arrays.asList("tasty", "test", "tste", "taste", "estt");

        for (String listWord : lists) {
            if (inputStr.length() != listWord.length()) {
                continue;
            }
            char[] inputChar = inputStr.toCharArray();
            char[] listWordChar = listWord.toCharArray();

            Arrays.sort(inputChar);
            Arrays.sort(listWordChar);

            if (Arrays.equals(inputChar, listWordChar)) {
                result.add(listWord);
            }
        }
        result.stream().forEach(System.out::println);

    }
}
