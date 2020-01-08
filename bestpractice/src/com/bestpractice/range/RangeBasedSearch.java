package com.bestpractice.range;

import java.util.SortedMap;
import java.util.TreeMap;

public class RangeBasedSearch {
    public static void main(String[] args) {
        Range range1 = new Range(20, 1);
        Range range2 = new Range(30, 2);
        Range range3 = new Range(40, 3);
        Range range4 = new Range(50, 4);
        Range range5 = new Range(60, 5);
        Range range6 = new Range(70, 6);

        TreeMap<Integer, Range> map = new TreeMap<Integer, Range>();
        map.put(10, range1);
        map.put(20, range2);
        map.put(30, range3);
        map.put(40, range4);
        map.put(50, range5);
        map.put(60, range6);


        System.out.println(map.floorEntry(25));

        map.entrySet()
                .stream()
                .forEach(e -> System.out.println("key: " + e.getKey() + " value: " + e.getValue()));


        getResult(map, 25);

    }

    private static int getResult(final SortedMap<Integer, Range> smap, final int key) {
        Range range = smap.get(key);
        if (null == range)
            return -1;
        else if (key <= range.getUppper())
            return range.getVal();
        else
            return -1;
    }
}
