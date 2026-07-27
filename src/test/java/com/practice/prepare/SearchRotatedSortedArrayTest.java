package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchRotatedSortedArrayTest {

    private final SearchRotatedSortedArray solver = new SearchRotatedSortedArray();

    @Test
    void findsTargetInRotatedArray() {
        assertEquals(4, solver.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
    }

    @Test
    void returnsNegativeOneWhenTargetMissing() {
        assertEquals(-1, solver.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
    }

    @Test
    void findsTargetInLeftSortedHalf() {
        assertEquals(1, solver.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5));
    }

    @Test
    void findsTargetInRightSortedHalf() {
        assertEquals(5, solver.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
    }

    @Test
    void handlesSingleElementFound() {
        assertEquals(0, solver.search(new int[] { 1 }, 1));
    }

    @Test
    void handlesSingleElementMissing() {
        assertEquals(-1, solver.search(new int[] { 1 }, 0));
    }
}
