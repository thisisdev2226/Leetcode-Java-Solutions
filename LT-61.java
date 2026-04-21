/**
 * LeetCode 61 - Rotate List
 * Link: https://leetcode.com/problems/rotate-list/
 *
 * Approach:
 * 1. Edge Case: If list is empty, has one node, or k = 0 → return head.
 * 2. Find length of linked list and last node (tail).
 * 3. Normalize k using k = k % len (to avoid extra rotations).
 * 4. Move fast pointer k steps ahead.
 * 5. Move slow and fast together until fast reaches last node.
 *    → slow will be at (len - k - 1) position (new tail).
 * 6. Break the list at slow.next and rearrange:
 *    - newHead = slow.next
 *    - slow.next = null
 *    - tail.next = old head
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: find length
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: normalize k
        k = k % len;
        if (k == 0) return head;

        // Step 3: move fast pointer k steps ahead
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Step 4: move slow and fast
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: rotate
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
