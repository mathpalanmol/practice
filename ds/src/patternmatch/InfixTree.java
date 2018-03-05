package patternmatch;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class InfixTree {

	private final Set<String> infixes = new LinkedHashSet<>();
	
	public String[] SearchNLogN(String input) {
	String[] suffixes = new String[input.length()];
    for (int i = 0; i < suffixes.length; i++) {
        suffixes[i] = input.substring(i);
    }
 //   Arrays.sort(suffixes);
    return suffixes;
}   

	    public boolean search(String search) {
	        return infixes.contains(search);
	    }
	    
	    
	    public static void main(String[] args) {
	    	InfixTree ref = new InfixTree();
	    	String[] str = ref.SearchNLogN("Anmol");
	    	for(String value : str){
	    		System.out.println(value);
	    	}
		}

	}


