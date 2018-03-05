package str;

public class StringPrac {

	public static void main(String[] args) {
		String greeting = "Hello world!";
		System.out.println(greeting);

		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
		String helloString = new String(helloArray);
		System.out.println(helloString);

		String palindrome = "Dot saw I was Tod";
		int len = palindrome.length();
		System.out.println(len);

		String quote = "Now is the time for all good " + "men to come to the aid of their country.";

		System.out.println(quote);

		String con = "My name is ".concat("Rumplestiltskin");
		System.out.println(con);

		String anotherPalindrome = "Niagara. O roar again!";
		char aChar = anotherPalindrome.charAt(9);
		System.out.println(aChar);

		String anotherPalindrome1 = "Niagara. O roar again!";
		String roar = anotherPalindrome1.substring(11, 15);
		System.out.println(roar);

		String s1 = "java";// creating string by java string literal
		char ch[] = { 's', 't', 'r', 'i', 'n', 'g', 's' };
		String s2 = new String(ch);// converting char array to string
		String s3 = new String("example");// creating java string by new keyword
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		String test = "banana";
		System.out.println(test.lastIndexOf('b'));
		System.out.println(test.lastIndexOf('b', 1));
		System.out.println(test.indexOf('b'));

		String strr1 = "hello";
		String strr2 = "hello";
		String strr3 = "Hello";
		String strr4 = new String("hello");

		System.out.println("\n\n\n\n\n");

		System.out.println(strr1 == strr2);
		System.out.println(strr2 == strr3);
		System.out.println(strr1 == strr4);

		System.out.println(strr1.equals(strr2));
		System.out.println(strr1.equals(strr4));
		
	    char[] ary =  strr1.toCharArray();
	    for(int i=0; i<ary.length; i++) {
	    	System.out.print(ary[i] + " | ");
	    }
	    
	    char cha = 'a';
	    int i = cha;
	    System.out.println(i);
	    
	    if('a' > 'b') {
	    	System.out.println("a is greater than b");
	    }

	}

}
