package practice.leetcode.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * The type Merge two binary trees.
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
 */
public class MergeTwoBinaryTrees {

    public static class TreeNode {
        private static final Logger LOGGER = LogManager.getLogger(TreeNode.class);

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Merge trees tree node.
     *
     * @param t1 the t 1
     * @param t2 the t 2
     * @return the tree node
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode mergedNode = new TreeNode(0);
        mergedNode.val = t1.val + t2.val;

        mergedNode.left = mergeTrees(t1.left, t2.left);
        mergedNode.right = mergeTrees(t1.right, t2.right);

        return mergedNode;
    }

    /**
     * Merge tree 2 tree node.
     *
     * @param t1 the t 1
     * @param t2 the t 2
     * @return the tree node
     */
    // 1. Create a stack
    // 2. Push the root nodes of both the trees onto the stack.
    // 3 While the stack is not empty, perform following steps :
    //      1. Pop a node pair from the top of the stack
    //      2. For every node pair removed, add the values corresponding to the two nodes and update the value of the corresponding node in the first tree
    //      3. If the left child of the first tree exists, push the left child(pair) of both the trees onto the stack.
    //      4. If the left child of the first tree doesn’t exist, append the left child of the second tree to the current node of the first tree
    //      5. Do same for right child pair as well.
    //      6. If both the current nodes are NULL, continue with popping the next nodes from the stack.
    // 4. Return root of updated Tree
    public TreeNode mergeTree2 (TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[] {t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }

            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }

            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }

        return t1;
    }
}
