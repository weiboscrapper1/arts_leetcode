package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {

    @Test
    public void islandPerimeter() {
        int[][] input = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        IslandPerimeter solution = new IslandPerimeter();

        for (int i = 0; i < 10000; i++) {
            assertEquals(16, solution.islandPerimeter(input));
        }
    }

    @Test
    public void islandPerimeter2() {
        int[][] input = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        IslandPerimeter solution = new IslandPerimeter();
        for (int i = 0; i < 10000; i++) {
            assertEquals(16, solution.islandPerimeter(input));
        }
    }
}