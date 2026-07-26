package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutDuplicatesTest {

    private final LongestSubstringWithoutDuplicates solver = new LongestSubstringWithoutDuplicates();

    @Test
    void findsLongestSubstringWithMixedCharacters() {
        assertEquals(3, solver.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void handlesAllSameCharacter() {
        assertEquals(1, solver.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void handlesRepeatsInMiddle() {
        assertEquals(3, solver.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void handlesEmptyString() {
        assertEquals(0, solver.lengthOfLongestSubstring(""));
    }
}
