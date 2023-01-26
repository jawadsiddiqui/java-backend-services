package com.java8;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

    private static AtomicInteger nextId = new AtomicInteger(0);

    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void main(String[] args) {
        System.out.println(threadId.get());
        System.out.println(threadId.get());

        System.out.println(threadId.get());


    }
}
