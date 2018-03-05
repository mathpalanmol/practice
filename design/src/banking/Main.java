package banking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String password = null;
		while (scan.hasNext()) {
			password = scan.next();
			if (password.equals("quit"))
				break;

			boolean b = validatePassword(password);
			if (b)
				System.out.println("valid password");
			else
				System.out.println("invalid password");
		}

	}
	// anmolmath@cpr

	private static boolean validatePassword(String password) {
		if (password.length() > 15 || password.length() < 8) {
			return false;
		}
		char[] splAry = { '@', '#', '$' };
		char[] inputAry = password.toCharArray();

		boolean flag = false;
		for (int j = 0; j < splAry.length; j++) {
			for (int i = 0; i < inputAry.length; i++) {
				if (splAry[j] == inputAry[i]) {
					return true;
				}

			}
		}
		if (flag == false) {
			return false;
		}

		return true;
	}
}
