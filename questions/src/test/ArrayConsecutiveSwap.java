package test;

//Given a array int a[]={2,5,1,9,3,7,2,8,9,3} and the no. of swap operations.We are allowed to do swap operations. 
//swap constraint: exchange only adjacent element. 
//Find the max number that can be formed using swap operations.
public class ArrayConsecutiveSwap {

	public static void main(String[] args) {
		int[] input = { 4, 3, 5 };
		int swaps = 2;
		int[] output = compute(input, swaps);
		System.out.println("Output: ");
		for (int value : output) {
			System.out.println(value + " ");
		}

	}

	private static int[] compute(int[] input, int swaps) {
		int sCount = swaps;
		for (int i = 0; i < input.length - 1; i++) {
			if (sCount == 0)
				break;
			boolean flag = false;
			int j = i;
			int count = 0;
			if (input[j + 1] > input[j]) {
				while (j < input.length - 1 && input[j + 1] > input[j] && sCount != 0) {
					sCount--;
					j++;
					flag = true;
					count++;

				}
			} else {
				int count1 = 0;
				while (input[j + 1] < input[j] && sCount != 0) {
					j++;
					count1++;
					sCount--;

				}
			}
			if (flag) {
				// j = i;
				while (count != 0 && j > 0) {
					swap(input, j, j - 1);
					count--;
					j--;
				}
			}

		}

		return input;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
