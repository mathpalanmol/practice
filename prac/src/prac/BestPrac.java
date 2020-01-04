package prac;

import java.util.HashMap;
import java.util.Map;

public class BestPrac {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("two", 2);
        map.put("one", 1);
        map.put("four", 4);
        map.put("three", 3);
        getMaxValue(map); // 4
        getMaxKey(map); // four
    }

    private static void getMaxKey(final Map<String, Integer> map) {
        String minKey = map.entrySet()
                .stream()
                .min((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .get()
                .getKey();
        System.out.println("MinKey: " + minKey);
    }

    private static void getMaxValue(final Map<String, Integer> map) {
        Integer maxValue = map.entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .get()
                .getValue();
        System.out.println("Maxvalue: " + maxValue);
    }
}
