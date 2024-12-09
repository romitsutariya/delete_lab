package com.walter.stream;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> generate=Stream.generate(() -> "Hello Stream!!!!!!");
        generate.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}

/*
* Generate method keeps going to generate the value , it will never end
*
* */
