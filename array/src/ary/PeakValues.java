package ary;


public class PeakValues {

	 // A binary search based function that returns index of a peak
    // element
    static int findPeakUtil(int arr[], int low, int high, int n)
    {
        // Find index of middle element
        int mid = low + (high - low)/2;  /* (low + high)/2 */
 
        // Compare middle element with its neighbours (if neighbours
        // exist)
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid]))
            return mid;
 
        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak ele	ment
        else if (mid > 0 && arr[mid-1] > arr[mid])
            return findPeakUtil(arr, low, (mid -1), n);
 
        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        else return findPeakUtil(arr, (mid + 1), high, n);
    }

	public static int peakElement1(int[] ary) {
		for (int i = 1; i < ary.length - 1; i++) {
            if((ary[i-1]<ary[i]) && (ary[i] > ary[i+1]))
            	return ary[i];
		}
		return -1;
		

	}

	public static void main(String[] args) {
		PeakValues ref = new PeakValues();
		int[] ary = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25, 100 };
		System.out.println(getPeakElement(ary));
	//	peak(ary,0,ary.length-1);
		System.out.println(peakElement1(ary));

	}

	public static Integer getPeakElement(int[] array) {

		if (array == null || array.length == 0) {
			return null;
		}

		int n = array.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == n - 1 || array[mid] >= array[mid + 1])) {
				System.out.println("peak Value: " + array[mid]);
				return array[mid]; // array[mid] is peak element
			} else if (mid > 0 && array[mid - 1] > array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}
}
