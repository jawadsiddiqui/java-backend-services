package com.java8;

import java.util.Random;



@FunctionalInterface
public interface UPIPayment {

    // only 1 abstract
    // abstract method force my implementation to override
    // default method we don't force to override it
    public abstract void method();

    // we can use default and static n number of count
    // default method 1......n
    // static method 1......n
    default double getScratchCard(){
        return new Random().nextDouble();
    }

    default double getScratchCardRange(){
        return new Random().nextDouble();
    }

    static double getCreditCardNumber()
    {
        return new Random().nextDouble();
    }

    static double getCreditCardNumber1()
    {
        return new Random().nextDouble();
    }

    static double getCreditCardNumber2()
    {
        return new Random().nextDouble();
    }
}
