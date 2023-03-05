package com.functionalInterface;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

//        Predicate<Integer> predicate = (integer) -> {
//            if(integer%2==0)
//            {
//                return true;
//            } else {
//                return false;
//            }
//        };

        Predicate<Integer> predicate = (t) -> t%2==0;

        System.out.println(predicate.test(10));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        list.stream().filter(predicate).forEach(t-> System.out.println("even: " + t));
        list.stream().filter(t -> t%3==0).forEach(t-> System.out.println("even3: " + t));

        Predicate<String> predicate1 = t-> {
          if(t.equalsIgnoreCase("Jhon")) {return true;} else { return  false;}
        };

        List<String> list1 = Arrays.asList("Jhon", "Abjhon", "Abaca");
        list1.stream().filter(predicate1).forEach(t-> System.out.println("Printing valid value:" + t));

    }
}
