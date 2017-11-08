package test;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for (int i = 0; i < count; i++) {
			int nodeCount = scan.nextInt();
			int[] preAry = new int[nodeCount];
			for (int j = 0; j < nodeCount; j++) {
				preAry[j] = scan.nextInt();
			}
			

		}
		scan.close();
	}



}
