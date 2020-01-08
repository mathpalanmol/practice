package com.list;

import java.util.Arrays;
import java.util.List;

public class AryList {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        List<Integer> list = Arrays.asList(1, 3, 5, 2, 4, 11);
        list.stream()
                .filter(e -> e > 3 && e < 10)
                .forEach(e -> {
                    output(e);
                });
    }

    private static void output(final Integer val) {
        System.out.println("value: " + val);
    }
}
