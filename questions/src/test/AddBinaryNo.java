package test;

public class AddBinaryNo {
	public static void main(String[] args) {
		String input1 = "1111";
		String input2 = "1101";
		String result = calculateBinarySum(input1, input2);
		System.out.println(result);
		System.out.println("Using API: \n" + usingApi(input1, input2));
	}

	private static String calculateBinarySum(String input1, String input2) {
		int len1 = input1.length();
		int len2 = input2.length();
		int diff = Math.abs(len1 - len2);
		StringBuilder sb = new StringBuilder();
		while (diff == 0) {
			sb.append("0");
			diff--;
		}
		if (len1 < len2) {
			input1 = sb.append(input1).toString();
		}
		if (len1 > len2) {
			input2 = sb.append(input2).toString();
		}
		String result = calculateBinarySum(input1, len1, input2, len2);
		return result;
	}

	private static String calculateBinarySum(String input1, int len1, String input2, int len2) {
		int index = 1;
		String carry = "0";
		String output = "";
		StringBuilder sb = new StringBuilder();
		while (len1 - index >= 0 && len2 - index >= 0) {

			if (input1.charAt(len1 - index) == input2.charAt(len2 - index)) {
				// it can be 0 or 1
				// if carry 1
				if (carry == "1") {
					if (input1.charAt(len1 - index) == '1') {
						carry = "1";
						output = "1";
					} else {
						// 0
						carry = "0";
						output = "1";
					}
				} else {// carry 0
					if (input1.charAt(len1 - index) == '1') {
						carry = "1";
						output = "0";
					} else {
						// 0
						carry = "0";
						output = "0";
					}
				}
			} else {// one is 0 and other is 1
				if (carry == "1") {
					output = "0";
					carry = "1";
				} else {
					output = "1";
					carry = "0";
				}
			}
			sb.append(output);
			index++;

		}
		if (carry == "1")
			sb.append(carry);
		return sb.reverse().toString();
	}

	static String usingApi(String str1, String str2) {
		if (str1 == null && str2 == null)
			return null;
		Integer value1 = Integer.parseInt(str1, 2);
		Integer value2 = Integer.parseInt(str2, 2);
		Integer output = value1 + value2;
		return Integer.toBinaryString(output);
	}

}
