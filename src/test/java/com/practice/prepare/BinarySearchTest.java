package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private final BinarySearch solver = new BinarySearch();

    @Test
    void findsExistingTarget() {
        assertEquals(4, solver.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
    }

    @Test
    void returnsNegativeOneWhenTargetMissing() {
        assertEquals(-1, solver.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
    }

    @Test
    void findsFirstElement() {
        assertEquals(0, solver.search(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
    void findsLastElement() {
        assertEquals(4, solver.search(new int[] { 1, 2, 3, 4, 5 }, 5));
    }
}
