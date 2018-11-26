package practice.leetcode.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseballGameTest {

    @Test
    public void calPoints() {
        BaseballGame solution = new BaseballGame();
        assertEquals(30, solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        assertEquals(27, solution.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}