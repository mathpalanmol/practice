
public class Recursion {

	// empty string length is 0. "".length() == 0
	// str.substring(index)
	public static String rec(String str){
			if(str.length() == 1)
				return str;
			
	   return rec(str.substring(1)) + str.substring(0, 1);
	}
	public static void print(int index){
		System.out.println(index);
	}
	public static void main(String[] args) {
		System.out.println("Output: " + rec("joy"));
//		System.out.println("".substring(0, 1));
	}

}
