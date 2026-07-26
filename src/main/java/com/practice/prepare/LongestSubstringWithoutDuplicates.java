package com.practice.prepare;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {

    /**
     * Returns the length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutDuplicates solver = new LongestSubstringWithoutDuplicates();
        System.out.println(solver.lengthOfLongestSubstring("abcabcbb")); // 3 ("abc")
        System.out.println(solver.lengthOfLongestSubstring("bbbbb"));   // 1 ("b")
        System.out.println(solver.lengthOfLongestSubstring("pwwkew")); // 3 ("wke")
    }
}
