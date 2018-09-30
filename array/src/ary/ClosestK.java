package ary;

public class ClosestK {

	// in a given array find closest to key k; anmol.m
	public int getck(int[] ary, int k) {
		int low = 0;
		int high = ary.length - 1;
		if (k <= ary[low]) // If K is less than array[low] and array is sorted
							// then diff of k and ary[low] is minimum always
			return ary[low];
		if (k >= ary[high])// same to the value of highest index for the
							// condition.
			return ary[high];

		return ary[findck(ary, low, high, k)];

	}

	// here k defintly lies within the array.
	private int findck(int[] ary, int low, int high, int k) {
		if (low == high) { // this means we've reached to single number.
			// Now either we have to check the left or right.
			if (k > ary[low]) {
				int dif1 = k - ary[low];
				int dif2 = ary[low + 1] - k; // low+1 will never exceed the length as
				// we a precheck and no has be in between low and high
				// and similar for low-1
				if (dif1 < dif2)
					return low;
				else
					return (low + 1);
			} else {
				int dif1 = ary[low] - k; // k is small
				int dif2 = ary[low - 1] - k;
				if (dif1 < dif2)
					return low;
				else
					return (low - 1);
			}
		} else {
			int mid = low + (high - low) / 2;// find mid to avoid overflow
			if (ary[mid] == k)
				return mid;
			if (k < ary[mid])
				return findck(ary, low, mid - 1, k);
			else
				return findck(ary, mid + 1, high, k);
		}
	}

	private int getDiff(int i, int j) {
		return Math.abs(i - j);

	}

	public static void main(String[] args) {
		ClosestK ref = new ClosestK();
		int[] ary = { 1, 4, 8, 12, 15, 22, 22, 24, 26, 29 };
		// System.out.println(getClosestK(ary, 0));
		System.out.println(ref.getck(ary, 22));
	}

	// private int findck(int[] ary, int low, int high, int k) {
	// if (low > high) {
	// int mid = low + (high - low) / 2; // Always left one
	//
	// if ((mid - 1) >= 0 && (mid + 1) < ary.length) { //go inside if mid is not
	// first or last elment
	// int min = Integer.MAX_VALUE;
	// if (k < ary[mid]) { //or low or high // can't be equal otherwise this will
	// never has executed.
	// int l=-1,r=-1;
	// if (getDiff(ary[mid], k) < min) {
	// l = getDiff(ary[mid], k);
	//
	// }
	// if (getDiff(k, ary[mid-1]) < min) {
	// r = getDiff(k, ary[mid - 1]);
	// }
	// if(l<r)
	// return mid;
	// else
	// return mid-1;
	//
	// } else {
	// int l=-1,r=-1;
	// if (getDiff(ary[mid], k) < min) {
	// l = getDiff(ary[mid], k);
	// }
	// if (getDiff(ary[mid + 1], k) < min) {
	// r = getDiff(k, ary[mid + 1]);
	// }
	// if(l<r)
	// return mid;
	// else
	// return mid+1;
	// }
	// }
	// return --low;
	// } else {
	// int mid = low + (high - low) / 2;// find mid to avoid overflow
	// if (ary[mid] == k)
	// return mid;
	// if (k < ary[mid])
	// return findck(ary, low, mid - 1, k);
	// else
	// return findck(ary, mid + 1, high, k);
	// }
	// }
}
