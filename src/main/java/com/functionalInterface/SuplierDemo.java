package com.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SuplierDemo  {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            return "only return get";
        };

        List<String> list = Arrays.asList();
        System.out.println(list.stream().findAny().orElseGet(supplier));
    }
}
