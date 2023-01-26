package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OCRScanner {
    public static void main(String[] args) {
        OCRScanner ocrScanner = new OCRScanner();
        System.out.println(ocrScanner.solution("apple", "a?le"));
    }

    public boolean solution(String S, String T) {
        // Implement your solution here
        String source = process(S);
        String target = process(T);

        if(source.length()!=target.length())
            return false;

        int i=0;
        while (i<source.length()) {
            if(source.charAt(i)=='?' || target.charAt(i)=='?') {
                i++;
                continue;
            } else if (source.charAt(i)!=target.charAt(i))
                return false;
            i++;
        }
        return true;

    }

    public String process(String str){
        List<Character> list = new ArrayList<>();
        int i=0;
        int n = str.length();

        while(i<n){
            char c = str.charAt(i);

            if(Character.isDigit(c)){
                int count = 0;
                while(i<n && Character.isDigit(str.charAt(i))){
                    count = (count * 10) + (str.charAt(i) - '0');
                    i++;
                }
                i--;
                for(int a=0;a<count;a++){
                    list.add('?');
                }
            } else {
                list.add(str.charAt(i));
            }
            i++;

        }

        StringBuilder ocr = new StringBuilder();
        for(Character s: list)
            ocr.append(s);

        return ocr.toString();
    }
}
