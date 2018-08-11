package ary;


import java.util.Arrays;
/* It is true for any three numbers.*/
/*Dutch national flag sorting problem
 * 
For this problem, your goal is to sort an array of 0, 1 and 2's 
but you must do this in place, in linear time and without any extra space (such as creating an extra array). 
This is called the Dutch national flag sorting problem. 
For example, if the input array is [2,0,0,1,2,1] then your program should output [0,0,1,1,2,2] 
and the algorithm should run in O(n) time.*/

public class Sort012 {

	// Algorithm
	//
	// The solution to this algorithm will require 3 pointers to iterate throughout
	// the array, swapping the necessary elements.
	//
	// (1) Create a low pointer at the beginning of the array and a high pointer at
	// the end of the array.[Object to put '0' to left and '2' to right.]
	// (2) Create a mid pointer that starts at the beginning of the array and
	// iterates through each element.
	// (3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and
	// decrease the high pointer by 1.
	// (4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and
	// increase the low and mid pointers by 1.
	// (5) If the element at arr[mid] is a 1, don't swap anything and just increase
	// the mid pointer by 1.
	//
	//

	public static void main(String[] args) {
		int[] ary = { 2, 2, 2, 0, 0, 0, 1, 1 };
		dutchNatFlag(ary);
		System.out.println(Arrays.toString(ary));
	}

	static int[] dutchNatFlag(int[] arr) {

		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		// one pass through the array swapping
		// the necessary elements in place
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, low++, mid++);
			} else if (arr[mid] == 2) {
				swap(arr, mid, high--);
			} else if (arr[mid] == 1) {
				mid++;
			}
		}

		return arr;

	}

	private static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;

	}

}
