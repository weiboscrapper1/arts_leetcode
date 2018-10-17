package practice.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 */
public class ZigZagConversion {
    /**
     * Convert string.
     * 首先定义变量rowIndex = 0~(numRows-1)
     * 一般来说，除了第一行和最后一行之外，都需要两个step,
     * firstStep = 2 * (numRows-rowIndex-1)
     * secondStep = 2 * rowIndex
     * 再讨论第一行和最后一行，虽然step都是定长的，即2(n-1)，但是考虑到其index==0和index==(numRows-1),也都是符合上面的两个steps。
     * 只是需要注意的是：
     * - 第一行，secondStep == 0时，直接将"跨度"设置为firstStep
     * - 最后一行，firstStep == 0时，直接将"跨度"设置为secondStep
     * 每行拷贝完毕后，都还需要返回该行拷贝了多少个字符，作为下行拷贝的下标。
     *
     * @param s       the s
     * @param numRows the num rows
     * @return the string
     */
    public String convert(String s, int numRows) {
        if (s == null
                || s.length() == 0
                || s.length() == 1
                || numRows <= 1) {
            return s;
        }
        char[] result = new char[s.length()];

        int index = 0;
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            int numberCopied = copyLine(numRows, index, rowIndex, result, s);
            index += numberCopied;
        }

        return String.valueOf(result);
    }

    private int copyLine(int numRows, int indexInDest, int rowIndex, char[] result, String s) {
        int numberCopied = 0;
        int indexInSrc = rowIndex;
        boolean isCopyByFirstStep = true;
        // for the first line,
        //     fistStep == 2(numRows - 1)
        //     secondStep == 0
        // for the second line,
        //     firstStep == 0
        //     secondStep == 2(numRows - 1)
        // but actually there is one step which is 2(numRows - 1)
        int firstStep = 2 * (numRows - rowIndex - 1);
        int secondStep = 2 * rowIndex;

        while (indexInSrc < s.length()) {
            result[indexInDest++] = s.charAt(indexInSrc);
            numberCopied++;

            if (isCopyByFirstStep) {
                indexInSrc += (firstStep == 0) ? secondStep : firstStep;
            } else {
                indexInSrc += (secondStep == 0) ? firstStep : secondStep;
            }

            // The followings are easy to understand but slower
            /*
            if (rowIndex == 0 || rowIndex == (numRows - 1)) {
                indexInSrc += Math.max(firstStep, secondStep);
            } else {
                indexInSrc += isCopyByFirstStep ? firstStep : secondStep;
            }
            */
            isCopyByFirstStep = !isCopyByFirstStep;
        }

        return numberCopied;
    }
}
