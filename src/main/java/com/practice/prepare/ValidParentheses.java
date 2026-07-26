package com.practice.prepare;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    /**
     * Returns true if the input string has valid matching parentheses.
     * Supports (), {}, and [].
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closingToOpening = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (closingToOpening.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != closingToOpening.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println(solver.isValid("()"));       // true
        System.out.println(solver.isValid("()[]{}"));   // true
        System.out.println(solver.isValid("(]"));       // false
        System.out.println(solver.isValid("{[]}"));     // true
    }
}
