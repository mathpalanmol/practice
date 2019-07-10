package ary;

import java.util.Arrays;

//Find next greater number with same set of digits

//Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
//If x is the greatest possible number with its set of digits, then print “not possible”.

//Input:  n = "218765"
//Output: "251678"

//Input:  n = "1234"
//Output: "1243"

//Input: n = "4321"
//Output: "Not Possible"

//Following is the algorithm for finding the next greater number.
//I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit.
//For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.
//
//II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
//
//III) Swap the above found two digits, we get 536974 in above example.
//
//IV) Now sort all digits from position next to ‘d’ to the end of number. 
//The number that we get after sorting is the output. 
//For above example, we sort digits in bold 536974. We get “536 479” which is the next greater number for input 534976.        
public class NextGreatest {
	static void swap(char ar[], int i, int j) {//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	// Given a number as a char array number[],
	// this function finds the next greater number.
	// It modifies the same array to store the result
	static void findNext(char ar[], int n) {
		int i;

		// I) Start from the right most digit
		// and find the first digit that is smaller
		// than the digit next to it.
		for (i = n - 1; i > 0; i--) {
			if (ar[i] > ar[i - 1]) {
				break;
			}
		}

		// If no such digit is found, then all
		// digits are in descending order means
		// there cannot be a greater number with
		// same set of digits
		if (i == 0) {
			System.out.println("Not possible");
		} else {
			int x = ar[i - 1], min = i;

			// II) Find the smallest digit on right
			// side of (i-1)'th digit that is greater
			// than number[i-1]
			for (int j = i + 1; j < n; j++) {
				if (ar[j] > x && ar[j] < ar[min]) {
					min = j;
				}
			}

			// III) Swap the above found smallest
			// digit with number[i-1]
			swap(ar, i - 1, min);

			// IV) Sort the digits after (i-1)
			// in ascending order
			Arrays.sort(ar, i, n);
			System.out.print("Next number with same" + " set of digits is ");
			for (i = 0; i < n; i++)
				System.out.print(ar[i]);
		}
	}

	public static void main(String[] args) {
		char digits[] = { '5', '3', '4', '9', '7', '6' };
		int n = digits.length;
		findNext(digits, n);
	}
}

// min priority queue for solution.

//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class AlgorithmFindNextSmallestSameStringSet {
//    public static String findNextSmallestSameStringSet(int number) {
//        char[] numberArray = String.valueOf(number).toCharArray();
//        int i;
//        PriorityQueue<Integer> pq = new PriorityQueue();
//        for(i=numberArray.length-1;i>0;i--) {
//            pq.add(Character.getNumericValue(numberArray[i]));
//            if(Character.getNumericValue(numberArray[i]) > 
//               Character.getNumericValue(numberArray[i-1])){
//                break; 
//            }
//        }
//        if(i == 0) {
//            return "NUMBER DOES NOT EXIST";
//        }
//        int temp = Character.getNumericValue(numberArray[i-1]);
//        numberArray[i-1] = pq.poll().toString().charAt(0);
//        pq.add(temp);
//        for(int j=i;j<numberArray.length;j++) {
//            numberArray[j] = pq.poll().toString().charAt(0);
//        }
//        return new String(numberArray);
//    }
//    
//    public static void main(String[] args) {
//        int number = 218765;
//        System.out.print("the next smallest with same string set of the number "+number+" is: ");
//        String nextSmallest = findNextSmallestSameStringSet(number);
//        System.out.println(nextSmallest);
//    }
//}
