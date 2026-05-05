/**
 * Problem: 92. Reverse Linked List II
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Approach:
 * - Use a dummy node to handle edge cases like reversing from head.
 * - Move `prev` to the node just before the `left` position.
 * - Keep `curr` at the start of the sublist to reverse.
 * - Repeatedly take the next node after `curr` and move it to the front
 *   of the reversing section (head insertion technique).
 *
 * Example:
 * 1 -> 2 -> 3 -> 4 -> 5, left = 2, right = 4
 *
 * Step 1:
 * 1 -> 3 -> 2 -> 4 -> 5
 *
 * Step 2:
 * 1 -> 4 -> 3 -> 2 -> 5
 *
 * Final:
 * 1 -> 4 -> 3 -> 2 -> 5
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Edge case: empty list or single node
        if (head == null || head.next == null) return head;

        // Dummy node handles cases where reversal starts from head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Move prev to one node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr points to first node of sublist to reverse
        ListNode curr = prev.next;

        // Reverse using head insertion
        for (int i = 0; i < right - left; i++) {
            ListNode temp = prev.next;      // store current front
            prev.next = curr.next;          // move next node to front
            curr.next = curr.next.next;     // remove moved node from original place
            prev.next.next = temp;          // connect moved node to front
        }

        return dummy.next;
    }
}
