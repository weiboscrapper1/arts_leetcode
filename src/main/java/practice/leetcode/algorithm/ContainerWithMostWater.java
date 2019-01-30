package practice.leetcode.algorithm;


/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    /**
     *
     * @param height the height
     * @return the int
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                // 去短板
                l++;
            } else {
                r--;
            }

        }

        return maxArea;
    }
}