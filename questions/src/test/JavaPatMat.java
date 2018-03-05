package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPatMat {
	public static void main(String[] args) {
		String str = "anmolnm";
	//	System.out.println(str.indexOf("nm"));
		Pattern p = Pattern.compile("nm");
		Matcher matcher = p.matcher(str);
		while(matcher.find()){//end index is one more than actual.
			System.out.println("startIndex: " + matcher.start() + " EndIndex: " + matcher.end());
		    
		}
	}


}
