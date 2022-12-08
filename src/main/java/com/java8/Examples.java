package com.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Examples {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        //How-to use lambda expressions
        // Copy method
//        public void run() {
//
//        }

        //remove signatures
//       () {
//
//        }

        // add  -->


        //remove signatures
        Runnable runnable1 = () -> {
            System.out.println("How I am using runnable interface");
        };


       Test test = (i) -> System.out.println("out"+ i) ;
       test.test(5);


        Function<Integer, String> function = (t) ->  "output: "+ t*25;
        System.out.println(function.apply(600));

        Supplier supplier = () -> {
            return  "supplier output";
        };

        System.out.println(supplier.get());


        Consumer consumer  = (t) -> System.out.println(t);

        consumer.accept(49);
    }
}
