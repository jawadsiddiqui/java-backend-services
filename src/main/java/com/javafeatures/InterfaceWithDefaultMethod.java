package com.javafeatures;

public interface InterfaceWithDefaultMethod {
    default void doit(){
        System.out.println("InterfaceWithDefaultMethod Default doit method");
    }
}
