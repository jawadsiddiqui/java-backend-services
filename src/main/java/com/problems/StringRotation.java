package com.problems;

public class StringRotation {

    public static void main(String[] args) {
        String str1  = "ABCD";
        String str2 = "CDAF";
       if( isRotation(str1, str2)) {
           System.out.println("Have Rotation");
       }
    }

    private static boolean isRotation(String str1, String str2){
        return (str1.length() == str2.length()) && ((str1+str1).contains(str2));
    }
}
