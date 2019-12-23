package practicesets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1st interviewer: Fibonnacci series, Given X, find all the sets of four numbers adding up to X.
//2nd interview: Remove white spaces in a string and lots of generic technical question
//3rd interview : lunch interview- general discussion on design patterns
//4th interview: Puzzle on 25 horses
//5th interview: Design a system to return location based merchandise.

public class Groupon {
	
	public static void main(String[] args) {
		String str = "this is medium level program";
		String output = process2(str);
		System.out.println("output: " + output);
		System.out.println('a' == 'b');
		Integer[] intAry = stringToDigits("12345");
		System.out.println(Arrays.toString(intAry));
	}

	private static Integer[] stringToDigits(String str) {
		int no = Integer.parseInt(str);
		Integer[] ary = new Integer[str.length()];
		int index = 0;
		while(no != 0) {
			ary[index++] = no % 10;
			no /= 10;
		}
		List<Integer> list = Arrays.asList(ary);
		Collections.reverse(list);
		return (Integer[]) list.toArray();
	}

	private static String process1(String str) {
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<str.length(); i++) {
			String val = new Character(str.charAt(i)).toString();
			if(val.equals(" ")) {
				continue;
			}
			sb.append(val);
		}
		return sb.toString();
	}
	
	private static String process2(String str) {
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i< str.length(); i++) {
			int val = (int)str.charAt(i);
			if(val == 32)
				continue;
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
		
	}

}
