package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequentWords {
    public static void main(String[] args) {
        int[] a = {34,3,4,5,3,54};
        int[] mostFrequentDigits = findMostFrequentDigits(a);
        System.out.println(Arrays.toString(mostFrequentDigits));
    }

    public static int[] findMostFrequentDigits(int[] a) {
        // Use a HashMap to store the frequency of each digit
        Map<Integer, Long> frequencyMap = Arrays.stream(a)
                .flatMap(i -> Integer.toString(i).chars())
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the maximum frequency
        long maxFrequency = frequencyMap.values().stream().max(Long::compare).get();

        // Collect all the digits that have the maximum frequency
        int[] mostFrequentDigits = frequencyMap.entrySet().stream()
                .filter(e -> e.getValue() == maxFrequency)
                .mapToInt(Map.Entry::getKey)
                .sorted()
                .toArray();
        return mostFrequentDigits;
    }
}

