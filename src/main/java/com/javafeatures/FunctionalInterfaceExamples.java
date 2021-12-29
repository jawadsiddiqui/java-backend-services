package com.javafeatures;

public class FunctionalInterfaceExamples implements FuncInterfaceExtend {

    public void method(String param) {
        System.out.println(param);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExamples functionalInterfaceExamples = new FunctionalInterfaceExamples();
        functionalInterfaceExamples.method("FuncInterfaceExtend method");
        functionalInterfaceExamples.doit();
    }
}
