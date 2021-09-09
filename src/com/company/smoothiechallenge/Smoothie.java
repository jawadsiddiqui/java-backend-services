package com.company.smoothiechallenge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Smoothie {
    static String[] ingredientsList
            = new String[]{"banana", "honey", "mango", "peach", "pineapple", "strawberry"};


    public static String ingredients(String order) {
        return getRemovedFromIngredients(order);

    }

    private static String getRemovedFromIngredients(String order) {


        if (order != "" && order.contains("-")) {
            String[] st = order.split("-");
            System.out.println(st);
            for (int i = 0; i < st.length; i++) {
                return Arrays.stream(ingredientsList).filter(item -> !item.contains(st[i].replace("-", ""))).collect(Collectors.joining(","));
            }
        }

        return Arrays.stream(ingredientsList).collect(Collectors.joining(","));


    }
}
