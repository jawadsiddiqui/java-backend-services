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

    /**
     * Implementation with lambda expression with no param.
     */
    public void LambdaNoParam() {
        InterfaceWithNoParam s = ()->{
           return "Lambda Expression with no parameter";
        };
    }

    /**
     * Implementation with lambda by using single parameter.
     */
    public void LambdaSingleParam() {
        //
        InterfaceWithSingleParam s = (name)->{
            return String.format("Lambda Expression with single parameter {}", name);
        };
        s.Say("Lambda");

        InterfaceWithSingleParam s1 = name -> {
            return "hello" + name;
        };
        s1.Say("Lambda");
    }
}
