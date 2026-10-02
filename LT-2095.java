/*
Problem: 2095. Delete the Middle Node of a Linked List
Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Approach:
1. Use the Slow and Fast Pointer approach to find the middle node.
2. Initialize both slow and fast at the head.
3. Move slow by one step and fast by two steps.
4. Stop when fast cannot move two steps further.
5. Delete the middle node by updating slow.next to slow.next.next.
6. If the list contains only one node, return null.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteMiddle(ListNode head) {

        // Handle an empty list or a single-node list
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the node just before the middle
        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        slow.next = slow.next.next;

        return head;
    }
}
