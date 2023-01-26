package com.java8;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        String[] word = new String[10];

        // it will definitely throw NullPointerException
       // word[5].length();

        word[5] = "";

        Optional<String> check = Optional.ofNullable(word[5]);

        if(check.isPresent()){
            System.out.println(check);
        } else System.out.println("NullException");

        System.out.println(    word[5].hashCode());

    System.out.println("hashcode:"+check.hashCode());


        Optional<String> empty = Optional.empty();
        System.out.println(empty);
    }
}
