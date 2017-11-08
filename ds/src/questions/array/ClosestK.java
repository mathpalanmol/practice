package questions.array;

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

	// Assumption k must be lying between ary,low,high. As we've already covered
	// base cases in calling method. Now k is either equal to any element in the array of it should lie between two numbers.
	private int findck(int[] ary, int low, int high, int k) {
		if (low >= high)
			return -1;// this should not reach
		else {
			int mid = low + (high - low) / 2;// find mid to avoid overflow
			if (mid + 1 > high)
				return mid;
			if (ary[mid] == k || ary[mid + 1] == k)// if k==mid; return either
													// mid or mid+1; with every iteration compare mid and mid + 1
				return mid;
			else if (k > ary[mid] && k < ary[mid + 1])
				return findMin(ary, k, mid);
			else {
				if (k < ary[mid])
					return findck(ary, low, mid, k);
				else
					return findck(ary, mid + 1, high, k);
			}
		}
	}

	private int findMin(int[] ary, int k, int mid) {
		if (Math.abs(k - ary[mid]) <= Math.abs(ary[mid + 1] - k))
			return mid;
		else
			return mid + 1;

	}

	public static void main(String[] args) {
		ClosestK ref = new ClosestK();
		int[] ary = { 1, 3, 7, 11, 12, 15, 22, 22, 24, 27, 29 };
		// System.out.println(getClosestK(ary, 0));
		System.out.println(ref.getck(ary, 22));
	}
}
