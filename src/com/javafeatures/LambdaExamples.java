package com.javafeatures;

interface InterfaceWithNoParam {
    public String Say();
}

interface InterfaceWithSingleParam {
    public String Say(String name);
}
public class LambdaExamples {
    public void withLambda(){
        Drawable d = ()->{
            System.out.println("With lambda expression.");
        };
        d.draw();
    }

    public void withoutLambda(){
        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println("without lambda expression.");
            }
        };
        d.draw();
    }

    public void LambdaNoParam() {
        InterfaceWithNoParam s = ()->{
           return "Lambda Expression with no parameter";
        };
    }

    public void LambdaSingleParam() {
        InterfaceWithSingleParam s = (name)->{
            return String.format("Lambda Expression with single parameter {}", name);
        };
    }
}
