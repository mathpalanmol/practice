package com.birthdeathyrs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMaxPopulation {

    private FindMaxPopulation() {
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = populateData();

        int minyr = findMinBirthYear(map);

        int maxyr = findMaxBirthYear(map);

        System.out.println("minyr: " + minyr + " maxyr: " + maxyr);

        int[] ary = new int[maxyr - minyr];
        //  getMaxPopulatedyr()

        //  getMaxPopulatedyr(map, ary, minyr);
    }

    private static Year getMaxPopulatedyr(int[] birthyrs, int[] deathyrs, int[] ary,
                                          final int minyr) {
        Year[] merge = merge(birthyrs, deathyrs);
        Year year = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < merge.length; i++) {
            if (merge[i].yearType.equals(YearType.BIRTH)) {
                ary[merge[i].getYear() - minyr] += ary[merge[i].getYear() - minyr];
            } else {
                ary[merge[i].getYear() - minyr] -= ary[merge[i].getYear() - minyr];
            }
            if (ary[merge[i].getYear() - minyr] > max) {
                max = ary[merge[i].getYear() - minyr];
                year = new Year(merge[i].getYear());
            }
        }
        return year;
    }

    private static Year[] merge(final int[] birthyrs, final int[] deathyrs) {
        Year[] mergedAry = new Year[birthyrs.length + deathyrs.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < birthyrs.length && j < deathyrs.length) {
            if (birthyrs[i] <= deathyrs[j]) {
                mergedAry[index] = new Year(birthyrs[i], YearType.BIRTH);
                i++;
            } else {
                mergedAry[index] = new Year(deathyrs[j], YearType.DEATH);
                j++;
            }
            index++;
        }
        return mergedAry;
    }

    private static int findMaxBirthYear(final LinkedHashMap<Integer, Integer> map) {
        LinkedHashMap<Integer, Integer> collect = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        return collect.values().stream().findFirst().get();
    }

    private static int findMinBirthYear(final LinkedHashMap<Integer, Integer> map) {
        LinkedHashMap<Integer, Integer> collect = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        return collect.keySet().stream().findFirst().get();
    }

    private static LinkedHashMap<Integer, Integer> populateData() {
        final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1980, 2050);
        map.put(1985, 2055);
        map.put(1982, 2060);
        map.put(1987, 2054);
        map.put(1990, 2053);
        map.put(1992, 2056);
        map.put(1990, 2060);
        map.put(1991, 2057);
        map.put(1988, 2057);
        return map;
    }

    public enum YearType {BIRTH, DEATH}

    public static class Year {
        int year;
        YearType yearType;

        private Year(final int year, final YearType yearType) {
            this.year = year;
            this.yearType = yearType;
        }

        private Year(final int year) {
            this.year = year;
        }

        private int getYear() {
            return year;
        }

        private void setYear(final int year) {
            this.year = year;
        }

        private YearType getYearType() {
            return yearType;
        }

        private void setYearType(final YearType yearType) {
            this.yearType = yearType;
        }

        @Override
        public String toString() {
            return "Year{" +
                    "year=" + year +
                    ", yearType=" + yearType +
                    '}';
        }
    }
}
