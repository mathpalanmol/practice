package com.bestpractice.range;

import java.util.Arrays;
import java.util.List;

public class CustomList {

    public static void main(String[] args) {


        final List<Integer> list = Arrays.asList(6, 2, 3, 4, 5);
        list.stream()
                .forEach(e -> System.out.println(e));
    }

}
