package practice.leetcode.algorithm;

/**
 * The type Binary number with alternating bits.
 */
public class BinaryNumberWithAlternatingBits {
    /**
     * Approach #1: Convert to String
     * Intuition and Algorithm
     * <p>
     * Let's convert the given number into a string of binary digits.
     * Then, we should simply check that no two adjacent digits are the same.
     * <p>
     * Complexity Analysis
     * <p>
     * Time Complexity: O(1).
     * For arbitrary inputs, we do O(w) work, where w is the number of bits in n.
     * However, w≤32.
     * <p>
     * Space complexity: O(1), or alternatively O(w).
     *
     * @param n the n
     * @return the boolean
     */
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach #2: Divide By Two
     * Intuition and Algorithm
     * <p>
     * We can get the last bit and the rest of the bits via n % 2 and n // 2 operations.
     * Let's remember cur, the last bit of n.
     * <p>
     * If the last bit ever equals the last bit of the remaining,
     * then two adjacent bits have the same value,
     * and the answer is False.
     * <p>
     * Otherwise, the answer is True.
     * <p>
     * Also note that instead of n % 2 and n // 2, we could have used operators n & 1 and n >>= 1 instead.
     * <p>
     * Complexity Analysis
     * Time Complexity: O(1). For arbitrary inputs, we do O(w) work, where ww is the number of bits in n.
     * However, w≤32.
     * <p>
     * Space complexity: O(1).
     *
     * @param n the n
     * @return the boolean
     */
    public boolean hasAlternatingBits2(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }

    /**
     * Has alternating bits 3 boolean.
     *
     * @param n the n
     * @return the boolean
     */
    public boolean hasAlternatingBits3(int n) {
        n ^= (n >> 1);
        return (n & (n + 1)) == 0 ? true : false;
    }
}
