package practice.leetcode.algorithm;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    /**
     * Approach 1: Recursive Approach
     * <p>
     * First let's cut \text{A}A into two parts at a random position i:
     * left_A             |        right_A
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * <p>
     * Since A has m elements, so there are m+1 kinds of cutting (i = 0~m).
     * <p>
     * And we know:
     * len(left_A)=i, len(right_A)=m-i
     * Note: when i=0, left_A is empty, and when i=m, right_A is empty.
     * <p>
     * With the same way, cut B into two parts at a random position j:
     * left_B             |        right_B
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * <p>
     * Put left_A and left_B into one set, and put right_A and right_B into another set. Let's name them left_part and right_part:
     * left_part          |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * <p>
     * i+j=k=(m+n+1)/2
     * <p>
     * median must from { A[i-1], B[j-1], A[i], B[j] }
     * <p>
     * Binary search i, based on a[i] < ? B[j-1]
     * <p>
     * Renmae the left part C.
     * C[0] C[1] C[2] ... C[k-1] C[k] ...
     * <p>
     * if (m+n) is odd, median is C[k-1] which is min(A[i-1], B[j-1])
     * if (m+n) is even, median are two two numbers:
     * C[k-1] = min(A[i-1], B[j-1])
     * C[k] = max(A[i], B[j])
     * <p>
     * --------------------------------------------
     * index    | 0     1   2   3   4   5   6   7
     * --------------------------------------------
     * num1     | -1    1   3   5   7   9
     * num2     | 2     4   6   8   10  12  14  16
     * --------------------------------------------
     * k = (m+n+1)/2=7
     * i = 4, j = 3
     * <p>
     * --------------------------------------------
     * index    | 0     1   2   3   4   5   6   7
     * --------------------------------------------
     * |
     * num1     | -1    1   3   5   7  |9
     * |----|
     * |
     * num2     | 2     4   6   8 |  10  12  14  16
     * --------------------------------------------
     * C[k-1] = max(A[i-i], B[j-1]) = max(5, 6) = 6
     * C[k] = min(A[i], B[j]) = min(7, 8) = 7
     * <p>
     * ________________________________________________________________
     * |                                                                |
     * |                    l = 0; r = m = 6                            |
     * |                    while(l < r)                                |
     * |________________________________________________________________|
     * |    l   |   r   |   i   |   j   |   A[i]    |   B[j-1]  |   C   |
     * |----------------------------------------------------------------|
     * |    0   |   6   |   3   |   4   |   5       |   8       |   <   |
     * |----------------------------------------------------------------|
     * |    4   |   6   |   5   |   2   |   9       |   4       |   >   |
     * |----------------------------------------------------------------|
     * |    4   |   5   |   4   |   3   |   7       |   6       |   >   |
     * |----------------------------------------------------------------|
     * |    4   |   4   |   -   |   -   |   -       |   -       |   -   |
     * ----------------------------------------------------------------
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthOfA = nums1.length;
        int lengthOfB = nums2.length;

        if (lengthOfA > lengthOfB) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = lengthOfA;
        int k = (lengthOfA + lengthOfB + 1) / 2;
        while (l < r) {
            int i = l + (r - l) / 2;
            int j = k - i;

            if (nums1[i] < nums2[j - 1]) {
                l = i + 1;
            } else {
                r = i;
            }
        }

        int i = l;
        int j = k - l;

        int c1 = Math.max(i <= 0 ? Integer.MIN_VALUE : nums1[i - 1],
                j <= 0 ? Integer.MIN_VALUE : nums2[j - 1]);

        if ((lengthOfA + lengthOfB) % 2 != 0) {
            return c1;
        }

        int c2 = Math.min(i >= lengthOfA ? Integer.MAX_VALUE : nums1[i],
                j >= lengthOfB ? Integer.MAX_VALUE : nums2[j]);

        return (c1 + c2) / 2.0;
    }
}
