package com.bestpractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 3);
        map.put("b", 1);
        map.put("c", 7);
        map.put("d", 5);

        iteration(map);


        HashMap<String, Integer> sortByKey = sortByKey(map);
        iteration(sortByKey);
        HashMap<String, Integer> sortByValue = sortByValue(map);
        iteration(sortByValue);

    }

    private static void iteration(final HashMap<String, Integer> map) {
        map.entrySet()
                .stream()
                .forEach(e -> System.out.println("key: " + e.getKey() + " value: " + e.getValue()));
    }

    private static HashMap<String, Integer> sortByValue(final HashMap<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    private static HashMap<String, Integer> sortByKey(final HashMap<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
