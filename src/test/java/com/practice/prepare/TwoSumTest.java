package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private final TwoSum solver = new TwoSum();

    @Test
    void findsTwoSumForBasicExample() {
        assertArrayEquals(new int[] { 0, 1 }, solver.twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }

    @Test
    void findsTwoSumWhenIndicesAreNotAdjacent() {
        assertArrayEquals(new int[] { 1, 2 }, solver.twoSum(new int[] { 3, 2, 4 }, 6));
    }

    @Test
    void findsTwoSumWithDuplicateValues() {
        assertArrayEquals(new int[] { 0, 1 }, solver.twoSum(new int[] { 3, 3 }, 6));
    }
}
