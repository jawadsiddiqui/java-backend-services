package com.problems;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashmap<K, V> {


    public void put(K key, V value)
    {
        int hash = hash(key);

        
    }

    private int hash(K v)
    {
        return v.hashCode();
    }
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    }
}
