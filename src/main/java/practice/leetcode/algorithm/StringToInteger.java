package practice.leetcode.algorithm;


/**
 * 8. String to Integer (atoi)
 *
 * implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character,
 * takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed,
 * a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values,
 * INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 */
public class StringToInteger {
    /**
     * My atoi int.
     *
     * @param str the str
     * @return the int
     */
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // i is the index of first non-space character
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i == str.length()) {
            // the string is full of spaces
            return 0;
        }

        boolean isNegative = false;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            i++;
            isNegative = true;
        } else if (ch > '9' || ch < '0') {
            return 0;
        }

        int result = 0;
        for (int j = i; j < str.length(); j++) {
            ch = str.charAt(j);
            if (ch > '9' || ch < '0') {
                break;
            }

            int temp = str.charAt(j) - '0';

            if (isNegative && (result > (Integer.MAX_VALUE) / 10 || (result == Integer.MAX_VALUE/10 && temp >= 8)))
                return Integer.MIN_VALUE;
            else if (!isNegative && (result > (Integer.MAX_VALUE) / 10 || (result == Integer.MAX_VALUE/10 && temp >= 7)))
                return Integer.MAX_VALUE;
            else {
                result = result * 10 + temp;
            }
        }

        if (isNegative) {
            return result * -1;
        } else {
            return result;
        }
    }
}
