package sort;

import java.util.Arrays;

//The Quick Sort is normally the fastest sorting algorithm
//O(nlogn) worst case O(n2) for similar values
//n efficient implementations it is not a stable sort, meaning that the relative order of equal sort items is not preserved. Quicksort can operate in-place on an array, 
//requiring small additional amounts of memory to perform the sorting
//T(n)=O(n)+2T(n/2) = nlogn
//T(n)=O(n)+T(n-1) = O(n2) {worst case, in case of sorted list no partition will take place}

public class Cquick {

	private static int[] theArray = { 1, 25, 3, 4, 5 };

	private static int arraySize;

	public static void main(String[] args) {

		System.out.println(Arrays.toString(Cquick.theArray));

		quickSort(0, 4);

		System.out.println(Arrays.toString(Cquick.theArray));

	}

	public static void quickSort(int left, int right) {

		if (right - left <= 0)//left>=right
			return; // Everything is sorted

		else {

			int pivot = theArray[right];// rightmost element 

			int pivotLocation = partitionArray(left, right, pivot);

			quickSort(left, pivotLocation - 1); // Sorts the left side

			quickSort(pivotLocation + 1, right);

		}

	}

	public static int partitionArray(int left, int right, int pivot) {//pivot is the last elment in the array, left-->0,
		//right -->pointer to the last element;

		int leftPointer = left - 1;

		int rightPointer = right;

		while (true) {

			while (theArray[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer) {

				break;

			}

			else {

				swapValues(leftPointer, rightPointer);

				System.out.println(theArray[leftPointer] + " was swapped for " + theArray[rightPointer]);

			}

		}

		swapValues(leftPointer, right);// this swap is for the pivot ie. swap left ptr with pivot index

		return leftPointer;

	}

	public static void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}

// public class Cquick {
//
// static int[] ary = { 21, 75, 22, 37, 8, 44, 71 };
//
// public static void main(String[] args) {
// partition(ary, 0, ary.length - 1);
// for (int value : ary)
// System.out.println(value);
//
// }
//
// public static void partition(int[] ary, int low, int high) {
// if(high>=low)
// return;
// int pivot = ary[high];
// int index = sort(ary, low, high, pivot);
// partition(ary, low, index - 1);
// partition(ary, index + 1, high);
// }
//
// private static int sort(int[] ary, int low, int high, int pivot) {
// while (true) {
// while (ary[low] <= pivot && low < high)
// low++;
// while (ary[high] >= pivot && high >= low)
// high--;
// if (high >= low)
// break;
// swap(ary, low, high);
// }
// swap(ary, pivot, ary[high]);
// return high;
// }
//
// private static void swap(int[] ary, int low, int high) {
// int temp = ary[low];
// ary[low] = ary[high];
// ary[high] = temp;
//
// }
//
// }
