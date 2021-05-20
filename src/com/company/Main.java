package com.company;

public class Main {

    public static void main(String[] args) {
        Stream01.CheckStream();
	    // write your code here
        //AddTwoBinaryNumbers("11","1" );
    }

    private static void AddTwoBinaryNumbers(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry  = sum / 2;
            i--;
            j--;
        }
        if(carry != 0) sb.append(carry);
        System.out.println(sb.reverse().toString());
    }
}
