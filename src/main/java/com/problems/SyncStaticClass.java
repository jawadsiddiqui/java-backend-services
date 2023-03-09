package com.problems;

public class SyncStaticClass extends  Thread {

    @Override
    public void run() {
        SyncStatic.incrementCounter();

    }


    public static void main(String[] args) {
        for (int i =0; i<10; i++){
            new SyncStaticClass().start();
        }
    }
}
