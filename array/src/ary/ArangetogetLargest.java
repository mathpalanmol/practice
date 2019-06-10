package ary;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given an array of numbers, arrange them in a way that yields the largest value. 
//For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
//And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value

//Solution

//Given two numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). 
//If XY is larger, then X should come before Y in output, else Y should come before. For example, let X and Y be 542 and 60. 
//To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.

public class ArangetogetLargest {

	// The main function that prints the
	// arrangement with the largest value.
	// The function accepts a vector of strings
	static void printLargest(List<String> lst) {

		Collections.sort(lst, new Comparator<String>() {

			// A comparison function which is used by
			// sort() in printLargest()
			@Override
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;
//              a.compareTo(b) give -1 mean 'a' is less than 'b' so 'a' should appear first in the list.
				return XY.compareTo(YX) > 0 ? -1 : 1; //If XY is larger, then X should come before Y 
				// XY.compareTo(YX) will return 1, it should appear first in list so -1. [o1-o2 always gives incresing order sequence] 
			    // example there are two no's a and b. a will appear before b if a.compareto(b) will give -1.
				// that's y we are reversing in above expression beacause in real our xy and yx, we don't have to swap.
				// if XY.compareTo(YX) is > 1 it means xy is greater and our a is x and b is y... no as per above
				// discussion x should appear before y .. i.e a before b... so function should return -1
			}
		});

		System.out.println(lst);
	}

	public static void main(String[] args) {
//      String[] ary = {"1", "34", "3", "98", "9", "76", "45", "4"};
      String[] ary  = {"54", "546", "548", "60"};
      printLargest(Arrays.asList(ary));
	}
}
