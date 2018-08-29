package practice.leetcode.algorithm;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    /**
     * Approach 1: Brute Force
     * The obvious brute force solution is to pick all possible starting and ending positions for a substring,
     * and verify if it is a palindrome.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n^3)
     * ​​Assume that nn is the length of the input string,
     * there are a total of n(n-1)/2 such substrings (excluding the trivial solution where a character itself is a palindrome).
     * Since verifying each substring takes O(n) time, the run time complexity is O(n^3)
     * <p>
     * Space complexity : O(1)
     * <p>
     * <p>
     * Error - Time Limit Exceeded
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String longest = new String();
        for (int l = 0; l < s.length(); l++) {
            for (int r = l + 1; r <= s.length(); r++) {
                String subString = s.substring(l, r);
                if (isPalindromic(subString) && (longest.length() < subString.length())) {
                    longest = subString;
                }
            }
        }

        return longest;
    }

    private boolean isPalindromic(String s) {
        int loop = s.length() / 2;
        for (int i = 0; i < loop; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 根据回文串的定义，正着和反着读一样，那我们是不是把原来的字符串倒置了，然后找最长的公共子串就可以了。
     * 例如，S = “ caba”，S’ = “ abac”，最长公共子串是 “aba”，所以原字符串的最长回文串就是 “aba”。
     * <p>
     * 关于求最长公共子串（不是公共子序列），有很多方法，这里用动态规划的方法
     * <p>
     * 整体思想就是，申请一个二维的数组初始化为 0，然后判断对应的字符是否相等，相等的话
     * matrix[i][j] = matrix[i-1][j-1] + 1 。
     * 当 i = 0 或者 j = 0 的时候单独分析，字符相等的话 matrix[i][j] 就赋为 1 。
     * matrix[i][j] 保存的就是公共子串的长度。
     * <p>
     * 再看一个例子，S = “abc435cba”，S’ = “abc534cba” ，最长公共子串是 “abc” 和 “cba” ，但很明显这两个字符串都不是回文串。
     * 所以我们求出最长公共子串后，并不一定是回文串，我们还需要判断该字符串倒置前的下标和当前的字符串下标是不是匹配。
     * <p>
     * 比如 S = "caba"，S’ = "abac" ，S'中 aba 的下标是 0 1 2 ，
     * 倒置前是 3 2 1，和 S 中 aba 的下标符合，所以 aba 就是我们需要找的。当然我们不需要每个字符都判断，我们只需要判断末尾字符就可以。
     * <p>
     *                              i
     *                              |
     *                              ^
     *                  0   1   2   3
     *              S   c  *a*  b   a
     *          S'
     *       0  a       0   1   0   1
     *       1  b       0   0   2   0
     * j --> 2  *a*     0   1   0   3
     *       3  c       1   0   0   0
     * <p>
     * 首先 i，j 始终指向子串的末尾字符。所以 j 指向的*a*倒置前的下标是 beforeRev = length - 1 - j = 4 - 1 - 2 = 1，
     * beforeRev, matrix[i][j], i 三者必须满足下面的关系，才能保证是回文。
     * i == (beforeReverse + matrix[i][j] - 1)
     * <p>
     * 时间复杂度：两层循环，O（n²）。
     * <p>
     * 空间复杂度：一个二维数组，O（n²）
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int[][] matrix = new int[s.length()][s.length()];
        StringBuilder reversed = new StringBuilder(s).reverse();

        int maxLength = 0;
        int maxEndPos = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                boolean equal = s.charAt(i) == reversed.charAt(j) ? true : false;
                if (!equal) {
                    continue;
                }

                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }

                if (matrix[i][j] > maxLength) {
                    int beforeReverse = s.length() - 1 - j;
                    if (i == (beforeReverse + matrix[i][j] - 1)) {
                        maxLength = matrix[i][j];
                        maxEndPos = i;
                    }
                }
            }
        }

        int endIndex = maxEndPos + 1;
        int startIndex = endIndex - maxLength;
        return s.substring(startIndex, endIndex);
    }

    /**
     * 就空间复杂度，对longestPalindrome2继续优化
     * 我们分析一下循环，i = 0 ，j = 0，1，2, 3
     * 更新一列，然后 i = 1 ，再更新一列，而更新的时候我们其实只需要上一列的信息，
     * 更新第 3 列的时候，第 1 列的信息是没有用的。所以我们只需要一个一维数组就可以了。
     * 但是更新 matrix[i] 的时候我们需要 matrix[i-1] 的信息，
     * 假设 a[3] = a[2] + 1，更新 a[4] 的时候， 我们需要 a[3] 的信息，但是 a[3] 在之前已经被更新了，
     * 所以 j 不能从 0 到 8 ，应该倒过来，a[8] = a[7] + 1，a[7] = a[6] + 1 ,
     * 这样更新 a[8] 的时候用 a[7] ，用完后才去更新 a [7]，保证了不会出错。
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int[] matrix = new int[s.length()];
        StringBuilder reversed = new StringBuilder(s).reverse();

        int maxLength = 0;
        int maxEndPos = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                boolean equal = s.charAt(i) == reversed.charAt(j) ? true : false;
                if (!equal) {
                    continue;
                }

                if (i == 0 || j == 0) {
                    matrix[j] = 1;
                } else {
                    matrix[j] = matrix[j - 1] + 1;
                }

                if (matrix[j] > maxLength) {
                    int beforeReverse = s.length() - 1 - j;
                    if (i == (beforeReverse + matrix[j] - 1)) {
                        maxLength = matrix[j];
                        maxEndPos = i;
                    }
                }
            }
        }

        int endIndex = maxEndPos + 1;
        int startIndex = endIndex - maxLength;
        return s.substring(startIndex, endIndex);
    }

    /**
     * 暴力破解优化
     *
     * 解法一的暴力解法时间复杂度太高，在 leetCode 上并不能 AC 。我们可以考虑，去掉一些暴力解法中重复的判断。我们可以基于下边的发现，进行改进。
     *
     * 首先定义 P（i，j）。
     *
     *         |- true  s[i,j]是回文串
     * P(i,j)= |
     *         |- false s[i,j]不是回文串
     *
     * 接下来
     * P(i,j)=(P(i+1,j−1) && S[i]==S[j])
     * 所以如果我们想知道 P(i，j)的情况，不需要调用判断回文串的函数了，只需要知道 P(i + 1，j - 1)的情况就可以了，
     * 这样时间复杂度就少了 O（n）。
     * 因此我们可以用动态规划的方法，空间换时间，把已经求出的 P（i，j）存储起来。
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome4(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];

        int maxLen = 0;
        String maxPal = "";

        for (int i = 1; i <= length; i++) {
            for (int l = 0; l < length; l++) {
                int r = i + l - 1;
                if (r >= length) {
                    break;
                }

                P[l][r] = (i == 1 || i == 2 || P[l + 1][r - 1]) && s.charAt(l) == s.charAt(r);
                if (P[l][r] && i > maxLen) {
                    maxPal = s.substring(l, r + 1);
                }
            }
        }
        return maxPal;
    }

    /**
     * Approach 4: Expand Around Center
     *
     * In fact, we could solve it in O(n^2) time using only constant space.
     *
     * We observe that a palindrome mirrors around its center.
     * Therefore, a palindrome can be expanded from its center, and there are only 2n-1 such centers.
     *
     * You might be asking why there are 2n-1 but not n centers?
     * The reason is the center of a palindrome can be in between two letters.
     * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
     *
     * @param s
     * @return
     */
    public String longestPalindrome5(String s) {
        if (s == null || s.length() < 1) return "";
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > r - l) {
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }

        return s.substring(l, r + 1);
    }

    private int expandAroundCenter(String s, int l, int r) {
        int L = l, R = r;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
