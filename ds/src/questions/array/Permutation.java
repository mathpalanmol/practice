package questions.array;

import java.util.ArrayList;
import java.util.List;

//Backtracking
//Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation
public class Permutation {

	static void practice(char[] ary, int low, int high) {
		if (low == high) {
			for (char value : ary)//printing the array
				System.out.print(value + " ");
			System.out.println("\n");
		} else {
			int k = low;
			for (int i = low; i <= high; i++) {
				swap(ary, k, i);
				practice(ary, k + 1, high);
				swap(ary, i, k);
			}
		}

	}

	private static List<String> permuation(char[] chAry, int low, int high, ArrayList<String> list) {
		if (low >= high) {
			StringBuffer buf = new StringBuffer();
			for (char ch : chAry) {
				buf.append(ch);
			}
			list.add(buf.toString());
		} else {
			int k = low;
			for (int i = low; i <= high; i++) {
				swap(chAry, k, i);
				permuation(chAry, k + 1, high, list);
				swap(chAry, i, k);
			}
		}

		return list;
	}

	// high --> length -1
	// not applicable for distinct permutation for repeated characters.
	public static void permutation(char[] cs, int low, int high) {

		if (low == high) { // for single character; nothing to swap; it
							// recursion it will be the last character of the
							// string
			for (char value : cs)
				System.out.print(value + " ");
			System.out.println("\n");
		} else {

			int index = low;// 'ABC'-> for loop output without recursion
							// i=0{A,B,C}; i=1{B,A,C}, i=2{C,B,A};
			for (int i = low; i <= high; i++) {
				swap(cs, index, i);
				permutation(cs, index + 1, high); // IMP: why index+ 1 not
													// i+1?low = index + 1
													// (consider index = 0 and
													// i is 1 scenario
													// { index = 0,i=1{B,A,C}},
													// so if
													// you increment low = i+1,
													// low will become 2 and
													// then 2nd index value will
													// be second indexed value,
													// which
													// is incorrect. 1st indexed
													// value should be compared
													// with itself first)
				swap(cs, i, index);
			}
		}
	}

	private static void swap(char[] ary, int i, int j) {
		char temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;

	}

	public static void main(String[] args) {
		permutation("ABC".toCharArray(), 0, 2);
		ArrayList<String> list = new ArrayList<String>();
		List<String> resultList = permuation("ABC".toCharArray(), 0, "ABC".toCharArray().length - 1, list);
		
	}

}
