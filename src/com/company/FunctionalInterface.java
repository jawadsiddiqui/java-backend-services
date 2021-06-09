package com.company;

public interface FunctionalInterface {
    /**
     * Now in JDK8 We can define method
     */
    public boolean test(String t);
    default void FunctionalInterfaceMethod(){
        System.out.println("Method in Functional Interface");
    }

}
