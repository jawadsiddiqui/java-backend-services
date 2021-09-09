package com.company.genericsfeatures;

//a simple generic class
public class GenericClass<T> {


    T obj;
    GenericClass(T o){
        obj = o;
    }

    public T getObj() {
        return obj;
    }

    void showType(){
        System.out.println("Type of T is " + obj.getClass().getName());
    }
}
