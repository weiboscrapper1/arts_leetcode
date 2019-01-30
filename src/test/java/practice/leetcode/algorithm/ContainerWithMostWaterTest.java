package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        assertEquals(49, solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, solution.maxArea(new int[]{1, 8}));
        assertEquals(6, solution.maxArea(new int[]{1, 8, 6}));
        assertEquals(6, solution.maxArea(new int[]{1, 8, 6}));
        assertEquals(6, solution.maxArea(new int[]{1, 8, 6, 2}));
        assertEquals(15, solution.maxArea(new int[]{1, 8, 6, 2, 5}));
        assertEquals(16, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4}));
        assertEquals(40, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8}));
        assertEquals(40, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3}));
    }
}