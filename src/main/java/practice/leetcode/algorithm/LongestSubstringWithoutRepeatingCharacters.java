package practice.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        char[] array = s.toCharArray();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int tempResult = 1;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(Integer.valueOf((int)array[i]), 1);

            for (int j = i + 1; j < array.length; j++) {
                Integer value = Integer.valueOf((int)array[j]);
                if (map.containsKey(value)) {
                    break;
                }

                map.put(value, 1);
                tempResult++;
            }

            if (tempResult > result) {
                result = tempResult;
            }

            if (result >= (array.length - i)) {
                return result;
            }


        }

        return result;
    }
}
