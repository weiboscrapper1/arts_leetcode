package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartitionITest {
    @Test
    public void testArrayPairSum() {
        ArrayPartitionI solution = new ArrayPartitionI();
        assertEquals(4, solution.arrayPairSum2(new int[]{1, 4, 3, 2}));
    }

    @Test
    public void testArrayPairSum2() {
        ArrayPartitionI solution = new ArrayPartitionI();
        assertEquals(-10000, solution.arrayPairSum1(new int[]{-10000, 10000}));
    }

    @Test
    public void testArrayPairSum3() {
        ArrayPartitionI solution = new ArrayPartitionI();
        assertEquals(-9999, solution.arrayPairSum1(new int[]{-10000, 1, 0, 10000}));
    }
}