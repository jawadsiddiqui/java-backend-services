package com.java8;

import java.util.*;

public class HashmapProblems {
    public static void main(String[] args) {
        //Problem 1: Given an array of integers, find the number of pairs that sum up to a given target value.
        int[] nums = {1, 5, 7, -1};
        int target = 6;
        coundPairs(nums, target);


        //Problem 2: Given a string, find the first non-repeating character and return its index. If it does not exist, return -1.

        String s = "leetcode";
        System.out.println(firstUniqChar(s));;


        //Problem 3: Given a list of strings, group the strings by their anagrams.

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        list.stream().forEach(System.out::println);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }


    private static int coundPairs(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;

        for(int num: nums){
            int complement = target - num;
            count += map.getOrDefault(complement, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        System.out.println(count);

        return count;
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


}
