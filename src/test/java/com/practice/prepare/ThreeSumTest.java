package com.practice.prepare;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private final ThreeSum solver = new ThreeSum();

    @Test
    void findsTripletsForClassicExample() {
        List<List<Integer>> expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        assertEquals(expected, solver.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    @Test
    void returnsEmptyWhenNoTripletExists() {
        assertEquals(List.of(), solver.threeSum(new int[] { 0, 1, 1 }));
    }

    @Test
    void handlesAllZeros() {
        assertEquals(List.of(List.of(0, 0, 0)), solver.threeSum(new int[] { 0, 0, 0 }));
    }

    @Test
    void hashSetFindsTripletsForClassicExample() {
        List<List<Integer>> expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        assertEquals(expected, solver.threeSumWithHashSet(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    @Test
    void hashSetReturnsEmptyWhenNoTripletExists() {
        assertEquals(List.of(), solver.threeSumWithHashSet(new int[] { 0, 1, 1 }));
    }

    @Test
    void hashSetHandlesAllZeros() {
        assertEquals(List.of(List.of(0, 0, 0)), solver.threeSumWithHashSet(new int[] { 0, 0, 0 }));
    }
}
