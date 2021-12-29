package com.javafeatures;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class PrimitiveFuncInterfaceExample {
    public static void main(String[] args) {
        IntPredicate intPredicate = index -> index >= 5;
        System.out.println(intPredicate.test(3));

        System.out.println(intPredicate.test(10));

        IntConsumer intConsumer = (p)-> System.out.println("IntConsumber"+p);
        intConsumer.accept(25);

        IntSupplier intSupplier = ()->10;
        System.out.println(intSupplier.getAsInt());
    }
}
