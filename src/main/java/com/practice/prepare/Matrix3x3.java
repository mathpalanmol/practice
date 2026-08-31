package com.practice.prepare;

import java.util.Arrays;

public class Matrix3x3 {

    private final int[][] matrix = new int[3][3];

    public Matrix3x3() {
        // default 3x3 matrix filled with zeros
    }

    public Matrix3x3(int[][] values) {
        if (values.length != 3 || values[0].length != 3) {
            throw new IllegalArgumentException("Matrix must be 3x3");
        }
        for (int i = 0; i < 3; i++) {
            matrix[i] = Arrays.copyOf(values[i], 3);
        }
    }

    public int get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, int value) {
        matrix[row][col] = value;
    }

    public void print() {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /** Returns {row, col} if found, otherwise null. */
    public int[] findElement(int target) {
        return SearchInMatrix.findElement(matrix, target);
    }

    public static void main(String[] args) {
        int[][] values = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        Matrix3x3 matrix = new Matrix3x3(values);
        System.out.println("3x3 Matrix:");
        matrix.print();
        System.out.println("Find 5: " + Arrays.toString(matrix.findElement(5)));
        System.out.println("Find 10: " + Arrays.toString(matrix.findElement(10)));
    }
}
