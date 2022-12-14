package com.problems;

public class TwoSumProblemDemo {
    public static void main(String[] arg){
        int[] arr = {1,2,33,33,99,100};
        System.out.println(Math.abs(-8));
        Math.abs(9);

        int sum=0;
        for( int i : arr){
            if(Math.abs(i)> 9 && Math.abs(i) <100 ){
                sum+=i;
            }
        }

        System.out.println(sum);
    }
}
