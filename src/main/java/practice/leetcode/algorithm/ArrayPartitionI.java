package practice.leetcode.algorithm;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    public int arrayPairSum2(int[] nums) {
        int[] hash = new int[20001];
        for (int ele : nums) {
            hash[ele + 10000]++;
        }

        int p = 0;
        int sum = 0;
        for (int i = 0; i < 20001; i++) {
            if (hash[i] == 0) {
                continue;
            }
            while (hash[i] != 0) {
                if (p % 2 == 0) {
                    sum += i - 10000;
                }
                p++;
                hash[i]--;
            }

        }
        return sum;
    }
}
