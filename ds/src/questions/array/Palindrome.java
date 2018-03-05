package questions.array;

public class Palindrome {

	public static void main(String[] args) {
//		Palindrome ref = new Palindrome();
//		String input = "abaaaba";
//		String str = input.substring(6, 7); // last index and size of string
//											// gives you the last index
//		String str1 = input.substring(6, 6);// no value and 6, 8 is error
//		String str2 = input.substring(6); // len-1 gives you last character
//		String input = "aabaa";
//		String test = "anmol";
//		for(int i=test.length()-1;i >= 0; i--){
//			System.out.println(test.substring(i, i+1));
//		}
//		System.out.println(str);
//		System.out.println(str1);
//		System.out.println(str2);
		
//		boolean output = ref.isPalindrome(input, 0, input.length() - 1);
//		System.out.println(output);
        System.out.println(rev("anmol"));
	}

	boolean isPalindrome(String input, int low, int high) {
		if (low == high)
			return true;
		if (low > high) // if they cross it means every thing was fine before
						// crossing. so palindrome. it a odd no case
			return true;
		// input.substring(high, high + 1); high = max index for first time and
		// high + 1 is length
		if (input.substring(low, low + 1).equals(input.substring(high, high + 1)))
			return isPalindrome(input, low + 1, high - 1);
		return false;
	}
	
	
	static String rev(String str){
		if(str.length() == 0)
			return "";
		String append = str.substring(0, 1);
		String str1 =  rev(str.substring(1));
		 return str = str1 +append;
	}

}