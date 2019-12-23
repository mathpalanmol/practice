package string;

import java.util.Arrays;
import java.util.List;

// If the length of string is n, then there can be n*(n+1)/2 possible substrings.
public class PrintAllSubStrings {

	public static void main(String[] args) {
		String str = "abc";
		printsubStrings(str);
		Integer[] ary = {1,2,3};
		List<Integer> list = Arrays.asList(ary);
		for(int value : list) {
			System.out.println(value);
		}
		System.out.println("######");
		
		Integer[] copyOf = Arrays.copyOf(ary,3);
	//	Arrays.fill(ary, 2);
		for(int value : copyOf) {
			System.out.println(value);
		}
	}

	private static void printsubStrings(String str) {
		for(int i=0; i<str.length(); i++) {
			// always use j+1
			for(int j=i+1; j<= str.length(); j++) {
				String subStr = str.substring(i, j);
				System.out.println(subStr);
			}
		}
		
	}

}
