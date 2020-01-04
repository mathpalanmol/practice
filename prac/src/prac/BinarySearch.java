package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 0, 10, 8, 6);
        List<Integer> sList = numbers.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .collect(Collectors.toList());
        sList.forEach(e->System.out.println(e));



    }

}

