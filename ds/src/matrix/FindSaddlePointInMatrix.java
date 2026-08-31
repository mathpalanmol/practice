package matrix;

//        What is Saddle point of Matrix?
//        Element is said to be Saddle point of Matrix if it is both a minimum of its row and a maximum of its column or vice versa.

//        STEP 1: Traverse the Matrix row by row and for each row, find the minimum element in that
//        row.
//        let say you find the minimum element at index j.
//
//        STEP 2: Check the maximum element on same column j.
//
//        STEP 3: If minimum element in row and maximum element in column j is same then that element is
//        Saddle point of Matrix.
//        If minimum element in row and maximum element in column j is not same then that row
//        doesn't has Saddle point and check next row.
//
//        STEP 4: Repeat above steps for all rows.

public class FindSaddlePointInMatrix {

    public FindSaddlePointInMatrix() {
        int[][] matrix = {
                {4, 5, 6},
                {7, 18, 9},
                {5, 1, 3}
        };
        printSaddlePoint(matrix);
    }

    public static void main(String[] args) {
        new FindSaddlePointInMatrix();
    }

    private void printSaddlePoint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean isSadlePointPresentInRow = true;

            int minimum = matrix[i][0];
            int colIndexOfRowMinimum = 0;

            //Find minimum in row.
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < minimum) {
                    minimum = matrix[i][j];
                    colIndexOfRowMinimum = j;
                }
            }

            //Find maximum in same column.
            for (int j = 0; j < matrix.length; j++) {
                if (minimum < matrix[j][colIndexOfRowMinimum]) {
                    isSadlePointPresentInRow = false;
                    break;
                }
            }

            if (isSadlePointPresentInRow) {
                System.out.println(minimum);
            }
        }
    }

}
