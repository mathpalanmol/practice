package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SearchInMatrixTest {

    private final int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    @Test
    void linearSearchFindsElement() {
        assertArrayEquals(new int[] { 1, 1 }, SearchInMatrix.findElement(matrix, 5));
    }

    @Test
    void linearSearchReturnsNullWhenMissing() {
        assertNull(SearchInMatrix.findElement(matrix, 10));
    }

    @Test
    void sortedMatrixSearchFindsElement() {
        int[][] sorted = {
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 3, 6, 9 }
        };
        assertArrayEquals(new int[] { 1, 1 }, SearchInMatrix.searchInSortedMatrix(sorted, 5));
    }
}
