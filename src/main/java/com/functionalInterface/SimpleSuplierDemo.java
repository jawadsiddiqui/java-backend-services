package com.functionalInterface;

import java.util.function.Supplier;

public class SimpleSuplierDemo implements Supplier<String> {
    @Override
    public String get() {
        return "only get";
    }

    public static void main(String[] args) {
        Supplier<String> supplier = new SimpleSuplierDemo();
        System.out.println(supplier.get());
    }
}
