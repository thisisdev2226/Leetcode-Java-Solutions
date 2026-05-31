/**
 * Problem: 142. Linked List Cycle II
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Approach:
 * - Use Floyd's Cycle Detection (Slow & Fast Pointer).
 * - Move slow by 1 step and fast by 2 steps.
 * - If they meet, a cycle exists.
 * - Reset slow to head.
 * - Move both one step at a time until they meet again.
 * - Meeting point is the start of the cycle.
 *
 * Time Complexity: O(N)
 * - First traversal detects cycle.
 * - Second traversal finds cycle start.
 *
 * Space Complexity: O(1)
 * - No extra data structures used.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
