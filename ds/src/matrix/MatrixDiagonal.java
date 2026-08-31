package matrix;

//Input : mat[3][3] = {{1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}}
//Output : 1 2 4 7 5 3 6 8 9.
//Explanation: We start from 1 
//Then from upward to downward diagonally i.e. 2 and 4
//Then from downward to upward diagonally i.e 7, 5, 3 
//Then from up to down diagonally i.e  6, 8 
//Then down to up i.e. end at 9.
//
//Input : mat[4][4] =  {{1,  2,  3,  10},
//                      {4,  5,  6,  11},
//                      {7,  8,  9,  12},
//                      {13, 14, 15, 16}}
//Output:  1 2 4 7 5 3 10 6 8 13 14 9 11 12 15 16 .

public class MatrixDiagonal {

	static final int MAX = 100; 
	  
    static void printMatrixDiagonal(int mat[][], int n) 
    { 
        // Initialize indexes of element to be printed next 
        int i = 0, j = 0; 
  
        // Direction is initially from down to up 
        boolean isUp = true; 
  
        // Traverse the matrix till all elements get traversed 
        for (int k = 0; k < n * n;) { 
            // If isUp = true then traverse from downward 
            // to upward 
            if (isUp) { 
                while (i >= 0 && j < n) { 
                j++;
                i--;
                	System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (i < 0 && j <= n - 1) 
                    i = 0; 
                if (j == n) { // Consider diagonal situation. when pointer is at last element i will be '-1' and j==n both are out of bound.
                    i = i + 2; 
                    j--; 
                } 
            } 
  
            // If isUp = 0 then traverse up to down 
            else { 
                for (; j >= 0 && i < n; i++, j--) { 
                    System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (j < 0 && i <= n - 1) 
                    j = 0; 
                if (i == n) { 
                    j = j + 2; 
                    i--; 
                } 
            } 
  
            // Revert the isUp to change the direction 
            isUp = !isUp; 
        } 
    }
    public static void main(String[] args) {
    	 int[][] mat =  {{1,  2,  3,  10},
      {4,  5,  6,  11},
      {7,  8,  9,  12},
      {13, 14, 15, 16}};
		printMatrixDiagonal(mat, mat.length);
	}
}