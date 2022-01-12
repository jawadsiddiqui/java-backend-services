package com.problems;

/**
 * Fibonacci Seriece In Recursive Call Java
 */
public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            System.out.println( fibonacciRecursion(i) + " ");
        }
    }

    public static int fibonacciRecursion(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }

}
