/**
 * Problem: 82. Remove Duplicates from Sorted List II
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Approach:
 * - Use a dummy node before head to handle edge cases (like deleting the first node).
 * - Maintain two pointers:
 *   1. prev → last confirmed unique node
 *   2. curr → current node for traversal
 * - Traverse the list:
 *   - Move curr forward while next node has same value (skip duplicates group).
 *   - If prev.next == curr → no duplicates, move prev forward.
 *   - Else → duplicates exist, skip entire group by linking prev.next = curr.next.
 *
 * Time Complexity: O(n)
 * - Each node is visited once.
 *
 * Space Complexity: O(1)
 * - No extra space used (in-place).
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
