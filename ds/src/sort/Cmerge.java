package sort;
//O(nlogn) in all phase: O(n) is to sort every level and log(n) to reach every level.
//this sort is not in-place algo but it is stable sort
//merge sort is not inplace - it requires auxilary arrays while merging.
// 0 based index: mid = low+high/2,ex: if five elements keep 3 elements at left and 2 at right
//algo: partition first half; partition second half; merge it
//make two copies of array. do the sorting and save it on original array
// merge sort is quite applicable if you have to sort linklist. you don't need extra space for merging
//log(nlogn) for all cases
//merge and insertion sort are stable sorts(A stable sort is one which preserves the original order of the input set)
//Mergesort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists. It only requires one pass (O(n)) through the list
//Merge sort is used when the data structure doesn't support random access
//When sorting a file which doesn't fit into memory, you might break it into chunks which fit into memory, sort these using quicksort, writing each out to a file, then merge sort the generated files.
public class Cmerge {

	static int[] ary = { 1, 7, 3, 4, 3, 6, 2, 9, 10,-2 };

	// low and high are start and end indexes.
	public static void partition(int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;// low + (high-low)/2
		partition(low, mid);
		partition(mid + 1, high);
		 System.out.println("Low: " + low + " High: " + high + " Mid: " + mid); 
		 //merge(ary, low, mid, high);
		merge(low, mid, high);
	}

	private static void merge(int low, int mid, int high) {
		int len1 = mid - low + 1;
		int len2 = high - mid;
		// ary1,2 to hold split parts, we used auxiliary arrays to avoid
		// overriding/replacing the old values while sorting in original array.
		int[] ary1 = new int[len1];
		int[] ary2 = new int[len2];
		int index = 0;
		// populating arrays:- first half
		for (int i = low; i <= mid; i++) {
			ary1[index] = ary[i];
			index++;
		}
		index = 0;
		// populating arrays:- second half
		for (int i = (mid + 1); i <= high; i++) {
			ary2[index] = ary[i];
			index++;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < ary1.length && j < ary2.length) {
			if (ary1[i] <= ary2[j]) {
				ary[low + k] = ary1[i];
				k++;
				i++;
			} else {
				ary[low + k] = ary2[j];
				k++;
				j++;
			}
		}
		while (i < ary1.length) {
			ary[low + k] = ary1[i];
			i++;
			k++;
		}
		// k=0;// I think not required
		while (j < ary2.length) {
			ary[low + k] = ary2[j];
			j++;
			k++;
		}

	}

//	static void partition(int[] ary, int low, int high) {
//		if (high <= low)
//			return;
//		int mid = (low + high) / 2;
//		partition(ary, low, mid);
//		partition(ary, mid + 1, high);
//	//	System.out.println("Low: " + low + " Mid: " + mid + " High: " + high);
//	}

	public static void main(String[] args) {
		partition(0, ary.length - 1);
		 for(int value : ary)
		 System.out.println(value);

		// Low: 0 High: 1 Mid: 0
		// Low: 2 High: 3 Mid: 2
		// Low: 0 High: 3 Mid: 1
		// Low: 4 High: 5 Mid: 4
		// Low: 4 High: 6 Mid: 5
		// Low: 0 High: 6 Mid: 3
		// 1734265
	}
}
