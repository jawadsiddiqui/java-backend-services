package com.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashmapCollisionExample {

    public static void main(String[] args) {
        HashMap<BadHashCode, String> badHashCodeStringHashMap= new HashMap<>();
        BadHashCode key1 = new BadHashCode(1);
        BadHashCode key2 = new BadHashCode(2);
        badHashCodeStringHashMap.put(key1,"v");
        badHashCodeStringHashMap.put(key2,"b");


        BadHashCode key3 = new BadHashCode(1);



        System.out.println(badHashCodeStringHashMap.get(key3));

    }

    static class BadHashCode{
        private int value;
        BadHashCode(int value){
            this.value = value;
        }

        @Override
        public int hashCode(){
            System.out.println("Calling hashCode()");
            return 1;
        }
    }
}
