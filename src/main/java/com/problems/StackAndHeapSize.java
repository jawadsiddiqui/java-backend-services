package com.problems;

public class StackAndHeapSize {
    public static void main(String[] args) {
        int length = Thread.currentThread().getStackTrace().length;
        System.out.println(length);

        long l = Runtime.getRuntime().totalMemory();
        System.out.println(l);


    }
}
