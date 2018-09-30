package ary;


// Input:  digits[] = "121"
// Output: 3
// The possible decodings are "ABA", "AU", "LA"

public class CountPossibleDecodings {
	static char[] config = new char[26];

	public static void main(String[] args) {
		populate();
		int[] ary = { 1, 2, 1,2,3,1,2 };
		StringBuilder sb = new StringBuilder();
		for (Integer value : ary) {
			sb.append(value.toString());
		}
		// The possible decodings are "ABA", "AU", "LA"
		printDecodings(sb.toString(), 0);
	}

	private static void populate() {
		for (int i = 0; i < config.length; i++) {
			int val = 65 + i;
			config[i] = (char) val;
		}

	}

	private static void printDecodings(String str, int count) {
		if (count > str.length() - 1)
			return;
		count++;
		String value = str.substring(0, count);
		printDecodings(str, count);

		int val = Integer.parseInt(value);
		System.out.println("val: " + val);
		if (val < 26) {
			StringBuilder sb = new StringBuilder();

			sb.append(config[val - 1]);
			String str1 = str.substring(count, str.length());
			int j = Integer.parseInt(str1);
			if(j < 26 && (j%10 > 0)) {
				j--;
				sb.append(config[j]);
				System.out.println(sb.toString());
				sb = new StringBuilder();
			}
			int c = 0;

			if (!"".equals(str1)) {
				while ((c + 1) <= str1.length()) {
					int index = Integer.parseInt(str1.substring(c, c + 1));
					index--;
					sb.append(config[index]);
					c++;
				}
			}
			System.out.println(sb);
		}

	}

}
