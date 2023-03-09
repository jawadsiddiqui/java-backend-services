package com.problems;

public class SyncStatic {
    private static int counter;

    public static synchronized void incrementCounter(){
        counter++;
        System.out.println(counter);
    }

    public static synchronized int getCounter(){
        return counter;
    }
}
