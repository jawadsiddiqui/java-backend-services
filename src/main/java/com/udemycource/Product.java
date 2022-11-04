package com.udemycource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    GREEN, BLUE, RED
}
enum Size {
    SMALL, MEDIUM, LARGE
}


public class Product {
    public Color color;
    public Size size;
    public String name;

    public  Product(String name, Color color, Size size){
        this.color = color;
        this.size = size;
        this.name = name;
    }
}

interface Specification<T>{
    boolean isSatisfied(T item);
}

interface  Filter<T> {
    Stream<T> filter(List<T> item, Specification<T> specification);
}

class BetterFilter implements Filter<Product>
{
    @Override
    public Stream<Product> filter(List<Product> item, Specification<Product> specification) {
        return item.stream().filter(specification::isSatisfied);
    }
}

class ColorSpecification implements Specification<Product>{

    private final Color color;

    public ColorSpecification(Color color){
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}


class SizeSpecification implements Specification<Product>{

    private final Size size;

    public SizeSpecification(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}


class AndSpecification<T> implements Specification<T> {
    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second){
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class Demo{
    public static void main(String[] args) {
        final Product apple = new Product("Apple", Color.GREEN, Size.MEDIUM);
        final Product tree = new Product("Tree", Color.GREEN, Size.MEDIUM);
        List<Product> p = new ArrayList<>();
        p.add(tree);
        p.add(apple);
        BetterFilter betterFilter
                 = new BetterFilter();
        betterFilter.filter(p, new ColorSpecification(Color.GREEN))
                .forEach(t-> System.out.println("-" + t.name + " is "+ t.color));

    }
}
