package com.java8;

import javafx.beans.binding.ObjectExpression;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class OddEvenCompletableFuture {

    private static Object object = new Object();

    private static IntPredicate evenCond = e->e%2==0;
    private static IntPredicate oddCond = e->e%2!=0;

    private static void printNumber(IntPredicate predicate){
        IntStream.rangeClosed(1,10).filter(predicate).forEach(OddEvenCompletableFuture::execute);
    }

    private static void execute(int number){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName()+":"+number);
                object.notify();
                object.wait();
            } catch (Exception ex){

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->OddEvenCompletableFuture.printNumber(oddCond));
        CompletableFuture.runAsync(()->OddEvenCompletableFuture.printNumber(evenCond));
        Thread.sleep(1000);
    }
}
