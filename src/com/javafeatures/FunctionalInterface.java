package com.javafeatures;


/**
 * FunctionalInterface annotation should be added for best practice.
 * One Abstract Method is allowed.
 * Multiple default methods are allowed - which have implementation with in interface.
 * Add @FuncationalInterface in interface to enforce the purpose.
 * We can use lambda expression to instantiate them.
 * @see java.lang.Runnable Runnable Functional Interface
 * @author jsiddiqui
 */
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
