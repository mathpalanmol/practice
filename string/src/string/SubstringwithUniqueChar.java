package string;

import java.util.Arrays;

// Count number of substrings with exactly k distinct characters.
//Input: abc, k = 2
//Output: 2
//Possible substrings are {"ab", "bc"}
//
//Input: aba, k = 2
//Output: 3
//Possible substrings are {"ab", "ba", "aba"}
//
//Input: aa, k = 1
//Output: 3
//Possible substrings are {"a", "a", "aa"}
public class SubstringwithUniqueChar {

	public static void main(String[] args) {
		SubstringwithUniqueChar ob = new SubstringwithUniqueChar();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                           k +    " distinct characters : "
                           + ob.countkDist(ch, k));
	}
	 int countkDist(String str, int k)
	    {
	        // Initialize result
	        int res = 0;
	 
	        int n = str.length();
	 
	        // To store count of characters from 'a' to 'z'
	        int cnt[] = new int[26];
	 
	        // Consider all substrings beginning with
	        // str[i]
	        for (int i = 0; i < n; i++)
	        {
	            int dist_count = 0;
	 
	            // Initializing count array with 0
	            // it will act as reset to 0 from second subtring onwards.
	            Arrays.fill(cnt, 0);
	 
	            // Consider all substrings between str[i..j]
	            
	            for (int j=i; j<n; j++)
	            {
	                // for first time encouter. value at char index will always be zero
	            	// if in a substring a char repeats multiple time. cnt[str.charAt(j) - 'a']>1 always.
	                if (cnt[str.charAt(j) - 'a'] == 0)
	                    dist_count++;
	 
	                // Increment count of current character
	                cnt[str.charAt(j) - 'a']++;
	 
	                // If distinct character count becomes k,
	                // then increment result.
	                if (dist_count == k)
	                    res++;
	            }
	        }
	 
	        return res;
	    }
}
