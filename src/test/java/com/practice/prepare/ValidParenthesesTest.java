package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

    private final ValidParentheses solver = new ValidParentheses();

    @Test
    void acceptsSimplePair() {
        assertTrue(solver.isValid("()"));
    }

    @Test
    void acceptsMultipleTypes() {
        assertTrue(solver.isValid("()[]{}"));
    }

    @Test
    void acceptsNestedValidParentheses() {
        assertTrue(solver.isValid("{[]}"));
    }

    @Test
    void rejectsMismatchedClosingBracket() {
        assertFalse(solver.isValid("(]"));
    }

    @Test
    void rejectsUnclosedOpeningBracket() {
        assertFalse(solver.isValid("("));
    }

    @Test
    void rejectsExtraClosingBracket() {
        assertFalse(solver.isValid("())"));
    }
}
