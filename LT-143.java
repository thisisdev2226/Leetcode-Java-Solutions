/**
 * Problem: 143. Reorder List
 * Link: https://leetcode.com/problems/reorder-list/
 *
 * Approach:
 * 1. Find middle of linked list using slow-fast pointer.
 * 2. Reverse the second half of the list.
 * 3. Detach first half from second half.
 * 4. Merge both halves alternatively.
 *
 * Time Complexity: O(n)
 *    - O(n) to find middle
 *    - O(n) to reverse second half
 *    - O(n) to merge
 *
 * Space Complexity: O(1)
 *    - In-place manipulation
 */
class Solution {

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null;

        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // Merge alternatively
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
