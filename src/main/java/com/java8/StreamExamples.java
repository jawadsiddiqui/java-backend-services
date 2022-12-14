package com.java8;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
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

    }
}
