package practice.leetcode.algorithm;


import java.util.*;

/**
 * 637. Average of Levels in Binary Tree
 * <p>
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: [3, 14.5, 11]
 * <p>
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * <p>
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * Approach #1 Breadth First Search
     * <p>
     * Another method to solve the given problem is to make use of a Breadth First Search.
     * In BFS, we start by pushing the root node into a queuequeue.
     * Then, we remove an element(node) from the front of the queuequeue.
     * For every node removed from the queuequeue, we add all its children to the back of the same queuequeue.
     * We keep on continuing this process till the queuequeue becomes empty.
     * In this way, we can traverse the given tree on a level-by-level basis.
     * <p>
     * But, in the current implementation, we need to do a slight modification, since we need to separate the nodes on one level from that of the other.
     * <p>
     * The steps to be performed are listed below:
     * <p>
     * 1. Put the root node into the queuequeue.
     * 2. Initialize sumsum and countcount as 0 and temptemp as an empty queue.
     * 3. Pop a node from the front of the queuequeue.
     * Add this node's value to the sumsum corresponding to the current level.
     * Also, update the countcount corresponding to the current level.
     * 4. Put the children nodes of the node last popped into the a temptemp queue(instead of queuequeue).
     * 5. Continue steps 3 and 4 till queuequeue becomes empty.
     * (An empty queuequeue indicates that one level of the tree has been considered).
     * 6. Reinitialize queuequeue with its value as temptemp.
     * 7. Populate the resres array with the average corresponding to the current level.
     * 8. Repeat steps 2 to 7 till the queuequeue and temptemp become empty.
     * <p>
     * At the end, resres is the required result.
     *
     * @param root the root
     * @return the list
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        // [NOTE]: The performance of LinkList is six times faster than ArrayList
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            long count = 0;

            // [NOTE]: Total must be long
            long total = 0;
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();

                total += n.val;
                count++;
                if (n.left != null) {
                    temp.add(n.left);
                }

                if (n.right != null) {
                    temp.add(n.right);
                }
            }

            queue = temp;

            result.add(total * 1.0 / count);
        }

        return result;
    }

    /**
     * Approach #2 Using Depth First Search
     *
     * One of the methods to solve the given problem is to make use of Depth First Search.
     * In DFS, we try to exhaust each branch of the given tree during the tree traversal before moving onto the next branch.
     *
     * To make use of DFS to solve the given problem, we make use of two lists and .
     * Here, refers to the total number of nodes found at the level(counting from root at level 0) till now,
     * and refers to the sum of the nodes at the level encountered till now during the Depth First Search.
     *
     * We make use of a function average(t, i, res, count),
     * which is used to fill the and array if we start the DFS from the node at the level in the given tree.
     * We start by making the function call average(root, 0, res, count).
     * After this, we do the following at every step:
     *
     * Add the value of the current node to the (or ) at the index corresponding to the current level.
     * Also, increment the at the index corresponding to the current level.
     *
     * Call the same function, average, with the left and the right child of the current node.
     * Also, update the current level used in making the function call.
     *
     * Repeat the above steps till all the nodes in the given tree have been considered once.
     *
     * Populate the averages in the resultant array to be returned.
     *
     * @param root the root
     * @return the list
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, sum, count);
        for (int i = 0; i < count.size(); i++) {
            result.add(sum.get(i) / count.get(i));
        }
        return result;
    }

    private void average(TreeNode t, int floor, List<Double> sum, List<Integer> count) {
        if (t == null) {
            return;
        }

        if (floor < sum.size()) {
            sum.set(floor, sum.get(floor) + t.val);
            count.set(floor, count.get(floor) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }

        average(t.left, floor + 1, sum, count);
        average(t.right, floor + 1, sum, count);
    }

    /**
     * Average of levels 3 list.
     *
     * @param root the root
     * @return the list
     */
    public List<Double> averageOfLevels3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        //do BFS layer by layer traversal, record the sum of each level and the size;
        //then divide the sum by the size, add the res to the list

        //Use queue to help do BFS, each time, we expand the curt node, it generate the left and
        //right child, we need to add them to the queue.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //the size of the curt level
            int size = queue.size();
            //the total sum of the current level
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //add each level's result to the final result list
            double result = (sum / (double) size);
            res.add(result);
        }

        return res;
    }

    // final solution
    public List<Double> averageOfLevels4(TreeNode root) {
        int hight = getHight(root, 0);
        int[] count = new int[hight];
        long[] sum = new long[hight];
        traverse(root, 0, count, sum);
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            result.add((double) sum[i] / (double) count[i]);
        }
        return result;
    }

    private void traverse(TreeNode node, int level, int[] count, long[] sum) {
        if (node == null)
            return;
        count[level]++;
        sum[level] += node.val;
        traverse(node.left, level + 1, count, sum);
        traverse(node.right, level + 1, count, sum);
    }

    private int getHight(TreeNode root, int currentHight) {
        if (root == null)
            return currentHight;
        int left = getHight(root.left, currentHight);
        int right = getHight(root.right, currentHight);
        return (left > right ? left : right) + 1;
    }
}
