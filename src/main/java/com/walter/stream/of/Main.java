package com.walter.stream.of;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

//this class is to demonstrate the stream.of method
public class Main {
    public static void main(String[] args) {
        Stream<Number> intStream= Stream.of(1.0,2,3,4,5,6,7,8,9);

        Consumer<Number> intConsumer=new Consumer<>() {
            @Override
            public void accept(Number s) {
                System.out.println("s = " + Number.class.isAssignableFrom(s.getClass()));
                System.out.println(s.getClass());
                Number n = s;
                System.out.println(n.getClass());
            }
        };
        intStream.forEach(intConsumer);

        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        System.out.println(String.class.isAssignableFrom(Object.class));

    }
}
