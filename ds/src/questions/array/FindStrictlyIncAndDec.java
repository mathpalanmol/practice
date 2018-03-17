package questions.array;

//Find an element in Bitonic array.
//O(log n) time. A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing

//Input :  arr[] = {-3, 9, 8, 20, 17, 5, 1};
//key = 20
//Output : Found at index 3

public class FindStrictlyIncAndDec {

	public static void main(String[] args) {
		// Let us search 20 in below array
		   int arr1[] = {-3, 9, 8, 20, 17, 5, 1};
		   int key = 20;
		   int x = searchBitonic(arr1, arr1.length, key);
		   if(x==-1)
			   System.out.println("Not found");
		   else
			   System.out.println("found");

	}

	static int ascendingBinarySearch(int arr[], int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// Binary Search function if array is
	// sorted in descending order
	static int descendingBinarySearch(int arr[], int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] < key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// Finds the index of maximum element
	// or the bitonic point
	static int findBitonicPoint(int arr[], int n) {
		int low = 0, high = n - 1;
		while (low <= high) {
			if (low == high)
				return arr[low];
			if (high == low + 1)
				return (arr[low] > arr[high]) ? low : high;

			// If there are atleast 3 elements
			int mid = low + (high - low) / 2;

			/*
			 * If arr[mid] is bitonic point return mid
			 */
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return mid;

			else if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid])
				low = mid + 1;
			else if (arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid])
				high = mid - 1;
			else
				return -1;
		}
		return -1;
	}

	static // Searches an element key in bitonic
	// array arr[] of size n
	int searchBitonic(int arr[], int n, int key) {
		// findBitonicPoint(arr, n) returns the
		// index of maximum element
		int k = findBitonicPoint(arr, n);
		if (arr[k] == key)
			return k;

		// Return -1 if key is greater than arr[k]
		// as arr[k] is the maximum element
		else if (key > arr[k])
			return -1;

		// Search in left of k
		int temp = ascendingBinarySearch(arr, 0, k - 1, key);
		if (temp != -1)
			return temp;

		// Search in right of k
		return descendingBinarySearch(arr, k + 1, n - 1, key);
	}

}
