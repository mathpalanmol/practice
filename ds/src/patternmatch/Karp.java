package patternmatch;

// calculate the hashcode of pattern; first char value + second char value * prime no + third * prime no square and so on
// travese the text equal to pattern length at one time. 
// calcuate the hashcode of text substring between low and high index;
// check for equality
// if they are equal check for the sequence. compare text and pattern char by char
// return starting index if true
public class Karp {

//	int calculateHashCode(String str) {
//		int hashCode = 0;
//		for (int i = 0; i < str.length(); i++) {
//			int code = str.charAt(i);
//			hashCode = (int) (hashCode + (code * Math.pow(3, i)));
//		}
//		return hashCode;
//
//	}
	int calculateHashCode(String str) {
		int hashCode = 0;
		for (int i = 0; i < str.length(); i++) {
			int code = hashCode * 31;//any prime no to get unique value
			hashCode = code + str.charAt(i);
		}
		return hashCode;

	}
	

	public int find(String text, String pattern) {
		char[] textary = text.toCharArray();
		int hashCode = calculateHashCode(pattern);
		int patLen = pattern.length();
		for (int index = 0; index < textary.length - 2; index++) {//2 => patLen-1
			boolean match = false;
			if (hashCode == calculateHashCode(text.substring(index, index + 3))) {
				for (int i = 0; i < patLen; i++) {
					if (text.charAt(index + i) != pattern.charAt(i)) {
						match = false;
						break;
					} else
						match = true;
				}
				if (match)
					return index;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Karp ref = new Karp();
		int index = ref.find("abcdefgh", "def");
		if (index != -1)
			System.out.println("String found at Index: " + index);
		else
			System.out.println("String not found.");
	}

}
