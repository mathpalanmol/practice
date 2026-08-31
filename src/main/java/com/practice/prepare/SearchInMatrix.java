package com.practice.prepare;

import java.util.Arrays;

public class SearchInMatrix {

    /**
     * Linear search in any matrix. Returns {row, col} or null if not found.
     */
    public static int[] findElement(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    return new int[] { row, col };
                }
            }
        }
        return null;
    }

    /**
     * Search in a row-wise and column-wise sorted matrix.
     * Each row is sorted left to right; each column is sorted top to bottom.
     * Start from top-right corner and move left or down.
     */
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] { row, col };
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Linear search for 5: " + Arrays.toString(findElement(matrix, 5)));
        System.out.println("Linear search for 10: " + Arrays.toString(findElement(matrix, 10)));

        int[][] sorted = {
                { 1,  4,  7 },
                { 2,  5,  8 },
                { 3,  6,  9 }
        };

        System.out.println("Sorted matrix search for 5: " + Arrays.toString(searchInSortedMatrix(sorted, 5)));
        System.out.println("Sorted matrix search for 6: " + Arrays.toString(searchInSortedMatrix(sorted, 6)));
    }
}
