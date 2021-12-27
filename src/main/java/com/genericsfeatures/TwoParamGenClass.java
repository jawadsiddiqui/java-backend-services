package com.genericsfeatures;

public class TwoParamGenClass<T, V> {

    T ob1;
    V ob2;

    TwoParamGenClass(T o, V v){
        ob1 = o;
        ob2 = v;
    }

    void showType(){
        System.out.println("Type of T is :" + ob1.getClass().getName());
        System.out.println("Type of V is :" + ob2.getClass().getName());

    }

    public T getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }


}
