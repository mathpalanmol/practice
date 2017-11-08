package questions.tree;

// With given count n how many possible BST can be generated.
// This problem can be solved using Dynamic Programming. 
public class CountNumberOfTreesInBST {

	int countTreesRec(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= numKeys; root++) {
				left = countTreesRec(root - 1);
				right = countTreesRec(numKeys - root);
				sum += left * right;
			}
			return (sum);
		}
	}

	// Dynamic Programming solution. Top Down approach.
	public int countBst(int n) {
		if (n == 0 || n == 1) // for n=0 means no node; assumption is with no
								// node null tree can be formed. It makes more
								// sense in further computations. for example if
								// left=0, it means no node at left side.
								// so left side will not contribute to the
								// count of BST's, because no combination can be
								// formed with zero nodes. so it should return 1
								// because this num will get multiplied with the
								// right side node contributions to get the
								// count.
								// 1*something is 1; so no contribution.
			return 1;
		int[] sumary = new int[n + 1]; // create temporary array to hold
										// intermediate result. for n=4 -->
										// 1,1,2,5,14. len = n+1 ? holds an
										// extra element at zeroth index
										// for n=0 ; which will be used for
										// left=0 or right=0.
		sumary[0] = 1; // index 0 means no node; value 1 stand for empty tree.
						// see above
						// explanation.
		sumary[1] = 1; // with one node only 1 tree is possible.
		// first loop provide the max index;
		for (int i = 1; i < n; i++) {// for zeroth node we've already saved
										// outcome in summary so no need to
										// process again. sumary[1] = 1;

			int count = 0; // for every ith node count should be reset to
							// zero before computation.
			// j is a pointer to last element of the current sequence, j acts as
			// a root and
			// it shifts towards the left side and changes the root to the
			// previous index value with every iteration and j always operates
			// between the range of i-->start and 0 end. with every shift of j
			// we compute the left and right combinations.
			for (int j = i; j >= 0; j--) {
				int left = j - 0;
				int right = i - j;
				count = count + (sumary[left] * sumary[right]);// [previous sum
																// + (left
																// possible
																// cases * right
																// possible
																// cases).]
				// every node get a channce to become root[right to left]

			}
			sumary[i + 1] = count; // i+1 because of an extra element in zeroth
									// index of sumary. sumary[0] = 1;
		}
		return sumary[sumary.length - 1]; // return last element
	}

	public static void main(String args[]) {
		CountNumberOfTreesInBST ref = new CountNumberOfTreesInBST();

		System.out.println(ref.countBst(50));
		System.out.println(ref.countBst(50));

	}
}