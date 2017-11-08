package questions.array;
public class ReplaceClosest {

	public static void main(String[] args) {
		// int[] ary = { 2, 3, 5, 7};
//		int[] ary = { 7, 3, 4, 6, 8 };
		int[] ary = {2,7,4,3,5,1,8,9};
		int temp = ary[ary.length - 1];
		//O(n)
		for (int i = ary.length - 2; i >= 0; i--) {
            int temp1 = 0;
			if (ary[i] < temp) {
				temp1 = ary[i];
				ary[i] = temp;
				temp = temp1;
			} else if (ary[i] < ary[i+1]) {
				temp1 = ary[i];
				ary[i] = ary[i+1];
				temp = temp1;
			}else
				temp = ary[i];

		}
		for (int value : ary)
			System.out.print(value);

	}
}