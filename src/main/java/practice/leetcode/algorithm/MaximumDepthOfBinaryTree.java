package practice.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Max depth int.
     *
     * @param root the root
     * @return the int
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int heigh = 0;

        while (!queue.isEmpty()) {
            heigh++;
            Queue<TreeNode> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    temp.add(node.left);
                }

                if (node.right != null) {
                    temp.add(node.right);
                }
            }

            queue = temp;
        }

        return heigh;
    }

    /**
     * Max depth 2 int.
     *
     * @param root the root
     * @return the int
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
