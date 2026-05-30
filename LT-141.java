/*
 * Problem: 141. Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach:
 * - Use Floyd's Cycle Detection Algorithm (Tortoise and Hare).
 * - Initialize two pointers: slow and fast.
 * - Move slow by 1 step and fast by 2 steps.
 * - If a cycle exists, both pointers will eventually meet.
 * - If fast reaches null or fast.next reaches null, there is no cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
