package matrix;

//Approach 3:
//        In this approach, we will start our search by looking at Right most element of first row.
//        If Current Element =  1, it means, no need to look down as all element down will be greater than 1 since columns are also sorted. move to next column (decrement column--).
//        If Current Element = 0, It means all element on left will surely be 0 and without traversing on left side directly add them all together by looking at column index and move to next row (increment row++).
//        Stop our search if control reaches the bottom left element or all columns are covered.

public class CountZeroInSortedMatrix {

    public CountZeroInSortedMatrix() {
        int[][] arr = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int column = arr[0].length - 1;
        int row = 0;
        int zeroCount = 0;

        while (row < arr.length && column >= 0) {
            if (arr[row][column] == 1) {
                column--;
            } else {
                zeroCount += column + 1;
                row++;
            }
        }
        System.out.println(zeroCount);
    }

    public static void main(String[] args) {
        new CountZeroInSortedMatrix();
    }
}

