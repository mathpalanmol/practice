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
//	[0, 1, 1, 2, 2, 2, 3, 3, 3, 3]
//			[0, 0, 0, 2, 2, 2, 4, 4, 5, 5]
	public static void main(String[] args) {
		int[] ary = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };
		System.out.println("Input: " + Arrays.asList(ary).toString());
		int[] hops = new int[ary.length];
		int[] origin = new int[ary.length];
		calculateMinJumps(ary, hops, origin);
		//new method
		System.out.println("\n New Method");
		calculateMinJumpsprac(ary, hops, origin);
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

// logic: for every element in ary will update reachable cells,	
	private static void calculateMinJumpsprac(int[] ary, int[] hops, int[] origin) {
		for (int i = 0; i < ary.length; i++) {
			int val = ary[i]; 
			// example, let say cell val is 3, it means from current cell location which is 'i' it can move up to val until and 
			// unless it's less than length ex. thing of last element(s)
			//zero index is assumed as zero. as distance to reach first cell is always zero
			for (int j = i + 1; j <= i + val && j < ary.length; j++) {
				ary[j] = Math.min(hops[j], hops[i] + 1);//we are always filing cells coming next to current cell. so if
				//we consider any arbitatory cell if it is reachable from any previous cell it value in hops array was there. so now we have to decide
				// which one is min, existing or currently computing(this hops is via current processing cell hops[i] + 1, hops[i] will give you
				//the steps required to reach current processing cell and then +1 to visit this reachable cell)
			}
		}
		System.out.println(Arrays.toString(hops));
	}

}
