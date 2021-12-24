package com.javafeatures;



//@FunctionalInterface annotation is used to ensure
// an interface can’t have more than one abstract method.
@java.lang.FunctionalInterface
public interface FunctionalInterface {

    /**
     * One Abstract Methods is allowed.
     * @return
     */
    public abstract boolean test();

    /**
     * functional interface can have multple default methods
     */
    default void FunctionalInterfaceMethod(){
        System.out.println("Method in Functional Interface");
    }

    default void staticMethods() {
        System.out.println("Method in Functional Interface");
    }
}
