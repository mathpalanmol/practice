package ary;

import java.util.Scanner;

/// 1011010101001 divisibley by n(any no) if yes return true. It will be stream of bytes.
public class BinaryStreamDivisibility {
	static int rem = 0;

	public static void main(String[] args) {
		int n = 3;
		Scanner scan = new Scanner(System.in);
		rem = scan.nextInt();
		if (rem % n == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		System.out.println("Press 2 to Quit");
		while (true) {
			int input = scan.nextInt();
			if (input == 2) {
				break;
			}
			boolean res = checkDivisibility(input, n);
			System.out.println(res);
		}
	}

	private static boolean checkDivisibility(int nextInt, int n) {
		if (nextInt == 0) {
			rem = rem * 2;
		} else {
			rem = rem * 2 + 1;
		}

		return (rem % n == 0) ? true : false;
	}
}
