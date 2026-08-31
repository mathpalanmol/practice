package string;

public class ReverseString {
    public static void main(String[] args) {
        String rev = reverseString("abcd", 0, "abcd".length() - 1);
        System.out.println(rev);
		System.out.println(reverse("abcd"));
    }

    private static String reverseString(String str, int low, int high) {
        if (low == high)
            return str.charAt(low) + "";
        return reverseString(str, low + 1, high) + str.charAt(low);
    }


    private static String reverse(String str) {
        if (str.length() == 1)
            return str;
        return reverse(str.substring(1)) + str.substring(0, 1);

    }
}
