package com.javafeatures;

public class MethodReference {

    MethodReference() {
        System.out.println("Constructor");
    }

    // static method
    public static void staticMethodExample(){
        System.out.printf("Static method");
    }

    // non-static method
    public void nonStaticMethodExample() {
        System.out.println("non-static method");
    }

    public static void main(String[] args) {
        //reference to static method
        Sayable sayable = MethodReference::staticMethodExample;
        sayable.say();

        //using predefined functional interface
        Thread thread = new Thread(MethodReference::staticMethodExample);
        thread.start();


        //Reference to an Instance method.
        MethodReference methodReference = new MethodReference();
        Sayable sayable1 = methodReference::nonStaticMethodExample;
        sayable1.say();

        //Static method referenced through non-static qualifier
        //Sayable sayable1 = methodReference::staticMethodExample;

        //Inline creating intance and calling non static method.
        Sayable sayable2 = new MethodReference()::nonStaticMethodExample;
        sayable2.say();

        //Reference to Constructor
        Sayable sayable3 = MethodReference::new;
        sayable3.say();
    }
}
