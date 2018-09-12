package practice.leetcode.algorithm;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AverageOfLevelsInBinaryTreeTest {
    @Test
    public void test() {
        TreeNode node_level0 = new TreeNode(3);
        TreeNode node_level1_left = new TreeNode(9);
        TreeNode node_level1_right = new TreeNode(20);
        node_level0.left = node_level1_left;
        node_level0.right = node_level1_right;

        TreeNode node_level2_left = new TreeNode(15);
        TreeNode node_level2_right = new TreeNode(7);
        node_level1_right.left = node_level2_left;
        node_level1_right.right = node_level2_right;

        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();


        List<Double> result = solution.averageOfLevels(node_level0);

        assertEquals(3, result.size());
        assertEquals(Double.valueOf(3), result.get(0));
        assertEquals(Double.valueOf(14.5), result.get(1));
        assertEquals(Double.valueOf(11), result.get(2));
    }

    @Test
    public void test_Performance() {
        TreeNode node_level0 = new TreeNode(3);
        TreeNode node_level1_left = new TreeNode(9);
        TreeNode node_level1_right = new TreeNode(20);
        node_level0.left = node_level1_left;
        node_level0.right = node_level1_right;

        TreeNode node_level2_left = new TreeNode(15);
        TreeNode node_level2_right = new TreeNode(7);
        node_level1_right.left = node_level2_left;
        node_level1_right.right = node_level2_right;

        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
        List<Double> result = solution.averageOfLevels2(node_level0);
        assertEquals(3, result.size());
        assertEquals(Double.valueOf(3), result.get(0));
        assertEquals(Double.valueOf(14.5), result.get(1));
        assertEquals(Double.valueOf(11), result.get(2));
    }
}