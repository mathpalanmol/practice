package ary;

// Divide and conquer 
//O(logn):- Modification to binary search
//{4,5,1,2,3}
public class ArrayRotation {
	int findRotateIndex(int[] ary, int low, int high) {

		if (ary[low] < ary[high])
			return -1; // -1 means array is not rotated.
		int mid = (low + high) / 2; // find mid

		/* Important step */
		int pre = (mid - 1 + ary.length) % ary.length; // mid=0,ary.length=5,pre
														// =4(last
														// element)-->first
														// element prev is last
														// element
		int next = (mid + 1) % ary.length; // mid = 4, next = 0(first element)

		if (ary[mid] < ary[pre] && ary[mid] < ary[next]) // face 3,1,2; 1 is
															// rotation point: mid is less then left and right.
			return mid;
		int index = -1;

		if (ary[low] <= ary[mid])// if (ary[low] <= ary[mid]); means from low to
									// mid the list is in sorted order so
									// rotating point should lie in next half
			index = findRotateIndex(ary, mid + 1, high);
		else
			index = findRotateIndex(ary, low, mid - 1);

		return index;

	}

	public static void main(String[] args) {
		ArrayRotation obj = new ArrayRotation();
		 int[] ary = { 2,3,1};
	//	 int[] ary = { 1,2,3,4,5 };
//		int[] ary = { 2, 3, 4, 5, 1 }; // if (ary[low] <= ary[mid]); // if low and
		// mid both point to same index findRotateIndex
		int index = obj.findRotateIndex(ary, 0, ary.length - 1);
		System.out.println("Rotated Index is: " + index);
		int index1 = obj.findRotation(ary, 0, ary.length - 1);
		System.out.println("Rotated Index is: " + index1);

	}
	
	
// for practice
	int findRotation(int[] ary, int low, int high) {
		if (ary[high] > ary[low])
			return -1;

		int mid = (low + high) / 2;
		int pre = (mid - 1 + ary.length) % ary.length;
		int next = (mid + 1)%ary.length;

		if (ary[mid] < ary[pre] && ary[next] > ary[mid]) {
			return mid;
		}
		if (ary[mid] >= ary[low])
			return findRotateIndex(ary, mid + 1, high);
		else
			return findRotateIndex(ary, low, mid - 1);

	}
}
