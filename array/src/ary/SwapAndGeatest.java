package ary;
//A swap operation M on an array is defined where you can only swap the
//
//adjacent elements. Given an array containing digits and n swap
//
//operations(defined as below), maximize the value of the array.
//
//Example: Array 1, 2, 4, 3 (value = 1243), Number of swaps 2
//
//Output 4,1,2,3 (value = 4123).






import java.util.Arrays;

public class SwapAndGeatest {

	public static void main(String[] args) {
//		int[] ary = {1,2,9,8,1,4,9,9,9};//{ 2, 4, 1, 8 };
		int[] ary = { 4, 3, 5 };//{7,5,9,9};
//		int[] ary = { 2, 4, 6, 8 };
		int swapCount = 1;
		int[] output = findGreatest(ary, swapCount);
		System.out.println(Arrays.toString(output));

	}

	private static int[] findGreatest(int[] ary, int swapCount) {
		for (int i = 0; i < ary.length - swapCount; i++) {
			int sCount = swapCount;
			for (int j = i + sCount; j > i; j--) {
				if (ary[j] > ary[j - 1]) {
					swap(ary, j, j - 1);
					sCount--;
					if (sCount == 0)
						break;
				}
			}
			swapCount = sCount;
			if (swapCount == 0) {
				break;
			}

		}
		return ary;
	}

	private static void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;

	}

}
