package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {

    @Test
    public void isMatch() {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("ab", ".*"));
        assertTrue(solution.isMatch("aab", "c*a*b*"));
        assertTrue(solution.isMatch("aab", "c*a*b"));
        assertFalse(solution.isMatch("mississippi", "mis*is*p*."));
        assertFalse(solution.isMatch("", "a"));
        assertFalse(solution.isMatch("", "."));
        assertTrue(solution.isMatch("", "a*"));
        assertTrue(solution.isMatch("", "a*b*"));
        assertTrue(solution.isMatch("abbbcd", "ab*bbbcd"));
        assertFalse(solution.isMatch("abcd", "d*"));
        assertFalse(solution.isMatch("ab", ".*c"));
        assertTrue(solution.isMatch("aaa", "a*a"));
    }
}