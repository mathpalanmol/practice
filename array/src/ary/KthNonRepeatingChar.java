package ary;


import java.util.LinkedHashMap;
import java.util.Map.Entry;

// Given a string and a number k, find the k'th non-repeating character in the string. Consider a large input string with lacs of characters and a small character set. How to find the character by only doing only one traversal of input string? Examples: Input : str = god is great, k = 3 Output : i First non-repeating character is o, second is d and third is i.

public class KthNonRepeatingChar {

	static LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<Character, Integer>();

	public static void main(String[] args) {
		char[] inputAry = "god is great".toCharArray();//args[0].toCharArray();
		int k = 2;

		for (int i = 0; i < inputAry.length; i++) {
			if (inputAry[i] == ' ')
				continue;
			else {
				if (!lmap.containsKey(inputAry[i])) {
					lmap.put(inputAry[i], 1);
				} else {
					int oldCount = lmap.get(inputAry[i]);
					lmap.put(inputAry[i], oldCount + 1);
				}
			}
		}
		int count = 1;
		for (Entry<Character, Integer> entry : lmap.entrySet()) {
			if (entry.getValue() == 1) {
				if (count == k) {
					System.out.println(entry.getKey());
					break;
				}
				count++;
			}
		}
	}

}
