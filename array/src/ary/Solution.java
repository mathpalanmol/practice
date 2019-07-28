package ary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
		public static List<String> restoreIpAddresses(String s) {
			return restore(s, s.length(), new ArrayList<String>());
		}
	
		private static List<String> restore(String str, int len, List<String> list) {
			String result = "";
			String temp1 = "";
			String temp2 = "";
			String temp3 = "";
			for (int i = 0; i < 3 && (i < len); i++) {
				if (isValidString(str.substring(0, i + 1))) {
					result += str.substring(0, i + 1);
					result += ".";
				}
				temp1 = result;
	//			System.out.println("result: " + result + " temp1: " + temp1);
				for (int j = i + 1; j < i + 4 && (j < len); j++) {
					result = temp1;
	//				System.out.println(str.substring(i + 1, j + 1));
					if (isValidString(str.substring(i + 1, j + 1))) {
						result += str.substring(i + 1, j + 1);
						result += ".";
					} else
						continue;
					temp2 = result;
	//				System.out.println("result: " + result + " temp2: " + temp2);
					for (int k = j + 1; k < j + 4 && (k < len); k++) {
						result = temp2;
						if (isValidString(str.substring(j + 1, k + 1))) {
							result += str.substring(j + 1, k + 1);
							result += ".";
						} else
							continue;
						temp3 = result;
	//					System.out.println("result: " + result + " temp3: " + temp3);
						int l = k + 1;
						System.out.println("length k: " + l);
						for (; (l < (k + 4)) && (l < len); l++) {
							result = temp3;
							if (isValidString(str.substring(k + 1, l + 1)))
								result += str.substring(k + 1, l + 1);
						}
						temp3 = "";
						// System.out.println("result: " + result);
						// result = "";
						if (l == len) {
							list.add(result);
							result = "";
							// System.out.println(Arrays.toString( list.toArray()));
						}
						result = "";
	
					}
					temp2 = "";
					result = "";
				}
				temp1 = "";
				result = "";
			}
			return list;
		}

	private static boolean isValidString(String substring) {
		int val = Integer.parseInt(substring);
		// System.out.print("val: " + val + " ");
		// System.out.print(val <= 255);
		return (val <= 255);
	}

	public static void main(String[] args) {
		List<String> list = restoreIpAddresses("25525511135");
		System.out.println(Arrays.toString(list.toArray()));
	}

}
