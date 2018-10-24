package practice.leetcode.algorithm;

/**
 * 7. Reverse Integer
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    /**
     * Reverse int.
     *
     * @param x the x
     * @return the int
     */
    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }

        long result = 0;
        do {
            int remainder = x % 10;
            result = result * 10 + remainder;

            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }

            x = x / 10;
        } while (x != 0);

        return (int) result;
    }
}

