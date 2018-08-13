package practice.leetcode.algorithm;

import org.junit.Test;
import practice.leetcode.algorithm.MergeTwoBinaryTrees.TreeNode;

import static org.junit.Assert.assertEquals;

public class MergeTwoBinaryTreesTest {

    // 	Tree 1
    //      1
    //     / \
    //    3
    //
    // 	Tree 2
    //      7
    //     / \
    //        9
    //         \
    //         100
    // Result
    //      8
    //     / \
    //    3   9
    //         \
    //         100
    @Test
    public void mergeTrees() {
        TreeNode t1Level1 = new TreeNode(1);
        TreeNode t1Level2Left = new TreeNode(3);
        t1Level1.left = t1Level2Left;

        TreeNode  t2Level1 = new TreeNode (7);
        TreeNode t2Level2Right = new TreeNode(9);
        t2Level1.right = t2Level2Right;

        TreeNode t2Leve3Right = new TreeNode(100);
        t2Level2Right.right = t2Leve3Right;

        MergeTwoBinaryTrees solution = new MergeTwoBinaryTrees();
        TreeNode result = solution.mergeTree2(t1Level1, t2Level1);

        assertEquals(8, result.val);
        assertEquals(3, result.left.val);
        assertEquals(null, result.left.left);
        assertEquals(null, result.left.right);
        assertEquals(9, result.right.val);
        assertEquals(null, result.right.left);
        assertEquals(100, result.right.right.val);
    }


    // 	Tree 1
    //      1
    //     / \
    //    3
    //
    // 	Tree 2: null
    //
    // 	result
    //      1
    //     / \
    //    3
    //
    @Test
    public void mergeTrees2() {
        TreeNode  t1Level1 = new TreeNode (1);
        TreeNode  t1Level2Left = new TreeNode (3);
        t1Level1.left = t1Level2Left;

        TreeNode  t2Level1 = null;

        MergeTwoBinaryTrees solution = new MergeTwoBinaryTrees();
        TreeNode result = solution.mergeTree2(t1Level1, t2Level1);

        assertEquals(1, result.val);
        assertEquals(3, result.left.val);
        assertEquals(null, result.right);
    }

    //      1
    //     / \
    //    2   3
    //   / \   \
    //  4   10  5
    //   \   /
    //    6 11
    //   / \
    //  7   8
    // 1 2 4 6 7 8 10 11 3 5
    @Test
    public void testPrint() {
        TreeNode  root = new TreeNode (1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(6);
        root.left.left.right.left = new TreeNode(7);
        root.left.left.right.right = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
    }
}