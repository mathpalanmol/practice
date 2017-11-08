package questions.array;

//find subset of a given array whose elements sums up to n.
//https://www.youtube.com/watch?v=5td2QH-x5ck
//Time complexity of the above solution is O(sum*n).
public class SubKarray {
	boolean[][] matrix = null;

	public boolean isSubset(int[] ary, int len, int sum) {
		matrix = new boolean[len + 1][sum + 1]; // len +1, sum+1{one extra zero
												// in row and in column}
		// initialize first column with true
		for (int i = 0; i <= ary.length; i++) {
			matrix[i][0] = true;
		}
		// initialize first row with false except the first block[0][0]; empty
		// subset is achievable with empty subset
		for (int i = 1; i <= sum; i++) {
			matrix[0][i] = false;
		}

		for (int i = 1; i <= len; i++) {// row =len; because of initial zero in
										// starting
			for (int j = 1; j <= sum; j++) {// column
				matrix[i][j] = matrix[i - 1][j];

				if (matrix[i][j] == false && j >= ary[i - 1]) {
					matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - ary[i - 1]];
				}
				// anmol.m start - To print all subsets equal to sum. this block
				// can be skipped if you don't want to print subsets.
				if (j == sum && matrix[i][j]) { // j==sum --> last column and
												// check if it is true. true
												// means sum can be achievable.
					int x = i;
					int y = j;
					matrix[x][y] = false; // mark it false (to skip it), to
											// avoid it's inclusion in
											// subsequent searches
					System.out.print(ary[x - 1] + " ");
					y = y - ary[x - 1]; // y = sum - observed value in input
										// array; y should be updated before x;
										// (why x-1?? x index is one greater
										// because of inclusion of 0(null subset
										// in the beginning of matrix) )
					x = x - 1;// one row up
					// why about two steps are outside for loop because we want
					// to update matrix[x][y] to false only if j == sum
					while (x > 0 && y > 0 && matrix[x][y]) {
						// matrix[x][y] == true; It's possible in two ways;
						// first: if matrix[x -1][y] == true,
						// second: ary[x - 1] - y == 0(for this
						// case we have to include ary[x - 1] )
						if (matrix[x - 1][y] == true && ary[x - 1] - y != 0)
							// if (matrix[x - 1][y] == true && y >ary[x - 1])
							// //todo: solution is not perfect for repeted
							// numbers in set
							// excluding current observed value i.e. ary[x - 1]
							x = x - 1;
						else {
							// Include current observed value i.e. ary[x - 1]
							// and print it.
							System.out.print(ary[x - 1] + " ");

							y = y - ary[x - 1];
							x = x - 1;
						}

					}
					System.out.println();
				}
				// anmol.m end
			}
		}
		return matrix[len][sum];
	}

	void display(int row, int column) {
		System.out.println("\n\nHere we go: \n");
		for (int i = 0; i <= row; i++) {// row
			for (int j = 0; j <= column; j++) {// column
				if (matrix[i][j])
					System.out.print("T ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SubKarray ref = new SubKarray();
		int[] ary = { 2, 3, 2, 1, 2 };
		// int[] ary = { 1, 3, 4, 7, 6, 2 };
		boolean output = ref.isSubset(ary, ary.length, 5);
		// System.out.println("Is subset: " + output + "\n\n");
		// check if an array is divided in to two arrays of equal sum
		// int sum = 0;
		// for(int i=0;i<ary.length;i++){
		// sum = sum + ary[i];
		// }
		// if(sum%2 !=0)
		// System.out.println("Division not possible");
		// else{
		// boolean output1 = ref.isSubset(ary, ary.length, sum/2);
		// System.out.println("Is subset: " + output1);
		// }
		// ref.display(ary.length, sum/2);// new boolean[len + 1][sum + 1];
		ref.display(ary.length, 5);// new boolean[len + 1][sum + 1];
	}
}
