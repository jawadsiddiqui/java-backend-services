package com.javafeatures;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        Integer integer = null;
        Optional<Integer> optionalInteger = Optional.ofNullable(integer);
        System.out.println(optionalInteger);
    }
}
