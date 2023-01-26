package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLedder {

    int solution(String beginWord, String endWord, String[] wordList) {
        //lets remove duplicate first
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        if(set.contains(endWord)) return 0;

        return  0;
    }


    public static void main(String[] args) {

    }
}
