package com.java8;


import java.util.Random;

@FunctionalInterface
public interface IPayment {

    String doPayment(String source, String dest);

    default double getScratchCard(){
        return new Random().nextDouble();
    }

}
