package practice.leetcode.algorithm;

/**
 * @Description: Number Complement
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 */
public class NumberComplement {
    // 先求出最高位为1的位数，然后计算出掩码，再将原数据取反后和掩码求与，即得出最后结果。
    // 其中，(1 << valid) - 1是二进制操作中一种常用的求掩码的方式
    public int findComplement(int num) {
        int valid = 0;  // 最高位为1的位数
        int tmp = num;
        while(tmp != 0) {
            tmp = tmp >> 1;
            valid++;
        }

        return ~num & ((1 << valid) - 1);
    }

    public int findComplement2(int num) {
        // num == 5 == 0x101
        // ~num = 11111111111111111111111111111010
        // Integer.highestOneBit(num) == 4 == 0b100
        // Integer.highestOneBit(num) - 1) == 0b011
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    public int findComplement3(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }
}
