package practice.leetcode.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * 876. Middle of the Linked List
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleOfTheLinkedList {

    /**
     * Approach 1: Output to Array
     * Intuition and Algorithm
     * <p>
     * Put every node into an array A in order.
     * Then the middle node is just A[A.length / 2], since we can retrieve each node by index.
     * <p>
     * Complexity Analysis
     * Time Complexity: O(N), where N is the number of nodes in the given list.
     * Space Complexity: O(N), the space used by A.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode middleNode(ListNode head) {
        List<ListNode> array = new ArrayList<>();

        ListNode list = head;
        while (list != null) {
            array.add(list);
            list = list.next;
        }

        return array.get(array.size() / 2);
    }

    /**
     * Approach 2: Fast and Slow Pointer
     * Intuition and Algorithm
     *
     * When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast.
     * When fast reaches the end of the list, slow must be in the middle.
     *
     * Complexity Analysis
     * Time Complexity: O(N), where NN is the number of nodes in the given list.
     * Space Complexity: O(1), the space used by slow and fast.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
