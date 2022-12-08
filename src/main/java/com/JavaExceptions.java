package com;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class JavaExceptions {
    public static void main(String[] args) {

        // divide by 0
        try {
            System.out.println(5 / 0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }


        String str = null;
        System.out.println(str.length());
    }
}
