package com.company;

public interface ClassFunctionalInterface {
    /**
     * Now in JDK8 We can define method
     */
    default void FunctionalInterfaceMethod(){
        System.out.println("Method in Functional Interface");
    }
}
