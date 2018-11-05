package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntegerTest {

    @Test
    public void myAtoi() {
        StringToInteger solution = new StringToInteger();
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(0, solution.myAtoi("+-2"));
        assertEquals(-42, solution.myAtoi("   -42"));
        assertEquals(4193, solution.myAtoi("4193 with words"));
        assertEquals(0, solution.myAtoi("words and 987"));
        assertEquals(-2147483648, solution.myAtoi("-91283472332"));
        assertEquals(2147483647, solution.myAtoi("9223372036854775808"));
        assertEquals(0, solution.myAtoi("    "));
    }
}