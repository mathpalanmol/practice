
public class ReverseString {

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
		System.out.println("Output: " + rec("jowhy"));
		System.out.println("a".substring(0, 1));
	}

	public String revString(String str) {
		if(str.length() == 1)
			return str;
		return revString(str.substring(1)) + str.substring(0, 1);
		
	}
	
}
