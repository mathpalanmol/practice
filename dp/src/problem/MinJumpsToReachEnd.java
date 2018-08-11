package problem;

import java.util.Arrays;

/*Given an array of integers where each element represents the max number of steps that can be made 
 * forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 -> 9)

First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
*/
public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int[] ary = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };
		int[] hops = new int[ary.length];
		int[] origin = new int[ary.length];
		calculateMinJumps(ary, hops, origin);
	}

	private static void calculateMinJumps(int[] ary, int[] hops, int[] origin) {
		// Process from second element to see what will be the min no of hops to reach
		// ith cell.
		// for cell 0 it will be always 0.
		for (int i = 1; i < ary.length; i++) {
			int min = Integer.MAX_VALUE;
			int start = -1;
			for (int j = 0; j < i; j++) {
				int value = ary[j];
				if ((value + j) < i)
					continue; // continue if we can reach to dest cell from given cell.
								// compare every 'jth' value and take minimum.
				if ((1 + hops[j]) < min) {
					min = 1 + hops[j]; // 1 is the hop to reach the destination and hops[j]; to reach 0 to jth.
					start = j; // log the start point.
				}
			}
			hops[i] = min;
			origin[i] = start;
		}
		System.out.println(Arrays.toString(hops));
		System.out.println(Arrays.toString(origin));
	}

}
