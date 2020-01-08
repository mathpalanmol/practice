package matrix;

// Given an n x n matrix,
// where every row and column is sorted in increasing order.  Given a number k,
//        how to decide whether this k is in the matrix

//In this approach, we will start our search by looking at Right most element of first row.
//        If Current Element =  Search element, Return True, element found.
//        If Current Element <  Search element, It means all element on left of current element are smaller and no need to look on left. Check element on next column.
//        If Current Element >  Search element, It means all element on below current element are higher and no need to look down. Check element in left side on same row.

public class SearchElementInSortedRowColumnMatrix {

    public SearchElementInSortedRowColumnMatrix() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int toSearch = 10;

        int column = arr[0].length - 1;
        int row = 0;
        boolean isFound = false;

        while (row < arr.length && column >= 0) {
            if (arr[row][column] == toSearch) {
                isFound = true;
                break;

            } else if (toSearch > arr[row][column]) {
                row++;

            } else {
                column--;
            }
        }
        System.out.println(isFound);
    }

    public static void main(String[] args) {
        new SearchElementInSortedRowColumnMatrix();
    }
}

