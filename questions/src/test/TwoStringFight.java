package test;

import java.util.ArrayList;

public class TwoStringFight {

	static boolean play(String str1, String str2) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		getPermutation(list1, str1.toCharArray());
		getPermutation(list2, str2.toCharArray());
		boolean result = true;
		for (String first : list1) { // both strings are of equal length
			char[] chAryf = first.toCharArray();
			for (String second : list2) {
				if(first.equals("ABCDE") && second.equals("HBIDK")){
					System.out.println();
				}
				char[] chArys = second.toCharArray();
				for (int i = 0; i < chAryf.length; i++) {
					if (chAryf[i] < chArys[i]) {
						result = false;
						break;
					}else
						result = true;
				}
				if (result)
					break;
			}
			if (result)
				break;
		}
		if (!result) {
			result = true;
			for (String second : list2) { // both strings are of equal length
				char[] chArys = second.toCharArray();
				for (String first : list1) {
					if(first.equals("ABCDE") && second.equals("HBIDK")){
						System.out.println();
					}
					char[] chAryf = first.toCharArray();
					for (int i = 0; i < chArys.length; i++) {
						if (chArys[i] < chAryf[i]) {
							result = false;
							break;
						}else
							result = true;
					}
					if (result)
						break;
				}
				if (result)
					break;
			}
		}
		return result;
	}

	static private void getPermutation(ArrayList<String> list, char[] chAry) {
		int low = 0;
		int high = chAry.length - 1;
		getPermutation(list, chAry, low, high);
	}

	private static void getPermutation(ArrayList<String> list, char[] chAry, int low, int high) {
		if (low >= high) {
			StringBuilder builder = new StringBuilder();
			for (char ch : chAry) {
				builder.append(ch);
			}
			list.add(builder.toString());
			return;
		}
		int k = low;
		for (int i = k; i < chAry.length; i++) {
			swap(chAry, i, k);
			getPermutation(list, chAry, k + 1, high);
			swap(chAry, k, i);
		}
	}

	private static void swap(char[] chAry, int i, int k) {
		char ch = chAry[i];
		chAry[i] = chAry[k];
		chAry[k] = ch;

	}

	public static void main(String[] args) {
		boolean output = play("BEDC", "BAFD");
		System.out.println(output);
	}

}
