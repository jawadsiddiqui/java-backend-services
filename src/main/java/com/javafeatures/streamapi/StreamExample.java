package com.javafeatures.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 3.4));
        productList.add(new Product(2, "Product 3", 10.4));
        productList.add(new Product(3, "Product 4", 100.4));

        Map<Integer, String> productListMap = productList.stream()
                .collect(Collectors.toMap(p->p.id,p->p.name));
        System.out.println(productListMap);


        List<Double> productPriceList = productList.stream()
                .filter(p -> p.price > 10.1)
                .map(p -> p.price)
                .collect(Collectors.toList());

        System.out.println(productPriceList);

        Stream.iterate(1, element->element+1)
                .filter(element->element%2==0)
                .limit(10)
                .forEach(System.out::println);


        productList.stream()
                .filter(p->p.price==10.4)
                .forEach(p -> System.out.println(p.name));

        //compact approach
        Double totalPrice = productList.stream()
                .map(p->p.price)
                .reduce(0.0d, (sum, price)->sum+price); //accumulating price
        System.out.println(totalPrice);

        //precise approach with method reference
        double totalPricePrecise = productList.stream()
                .map(p->p.price)
                .reduce(0.0d, Double::sum);
        System.out.println(totalPricePrecise);

        double totalPriceUsingCollector = productList.stream()
                .collect(Collectors.summingDouble(p->p.price));
        System.out.println(totalPriceUsingCollector);

        //Converting productlist to set
        //Removes duplicate
        Set<Double> productList1 = productList.stream()
                .filter(p->p.price<10)
                .map(p->p.price)
                .collect(Collectors.toSet());
        System.out.println(productList1);

        Stream.iterate(1, element -> element + 1)
                .filter(p->p%3==0)
                .limit(10)
                .forEach(System.out::println);



    }
}
