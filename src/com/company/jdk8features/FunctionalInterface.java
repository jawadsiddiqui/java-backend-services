package com.company.jdk8features;



//@FunctionalInterface annotation is used to ensure
// an interface can’t have more than one abstract method.
@java.lang.FunctionalInterface
public interface FunctionalInterface {

    //only one abstract method is allowed
    //
    public abstract boolean test();

    /**
     * functional interface can have multple default methods
     */
    default void FunctionalInterfaceMethod(){
        System.out.println("Method in Functional Interface");
    }
}
