package com.java8;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class StreamExamples {
    public static void main(String[] args) {
        List<User> list =
                Stream.of(new User("", Arrays.asList("a@gmail.com,ab@gmail.com")))
                        .collect(Collectors.toList());

        List<String> email = list.stream().map(User::getName).collect(Collectors.toList());

        List<List<String>> email1 = list.stream().map(User::getEmail).collect(Collectors.toList());

        List<String> emailFlatMap = list.stream().flatMap(u->u.getEmail().stream()).collect(Collectors.toList());

        System.out.println(emailFlatMap);



        List<Employee> employee =
                Stream.of(new Employee("James",1530000, "DEV"),
                                new Employee("Jack",130000, "QA"),
                                new Employee("Jane",140000, "QA"),
        new Employee("Jack",110000, "SQA"),
        new Employee("Jassy",115000, "SQA"))
                        .collect(Collectors.toList());

        Map<String, List<Employee>> collect =
                employee.stream().collect(Collectors.groupingBy(u -> u.getDepartment()));
        Comparator<Employee> compareBySalary  = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> collect1 = employee.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.reducing(

                                BinaryOperator.maxBy(
                                Comparator.comparing(Employee::getSalary)))));

        System.out.println(collect1);
    }
}
