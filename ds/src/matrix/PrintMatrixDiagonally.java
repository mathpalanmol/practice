package matrix;

public class PrintMatrixDiagonally {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        printMatrixDiagonally(matrix);
    }

    private static void printMatrixDiagonally(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int row = i;
            int col = 0;

            while (row >= 0 && col < matrix[0].length) {
                System.out.print(matrix[row][col] + " ");
                col++;
                row--;
            }
            System.out.println();
        }

        for (int i = 1; i < matrix[0].length; i++) {
            int row = matrix.length - 1;
            int col = i;

            while (row >= 0 && col < matrix[0].length) {
                System.out.print(matrix[row][col] + " ");
                col++;
                row--;
            }
            System.out.println();
        }
    }

}

