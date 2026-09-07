/*
 * Problem: 2487. Remove Nodes From Linked List
 * Link: https://leetcode.com/problems/remove-nodes-from-linked-list/
 *
 * Approach:
 * 1. Reverse the linked list so that we can process nodes from right to left.
 * 2. Keep track of the maximum value seen so far.
 * 3. If the next node's value is smaller than max, remove it.
 * 4. Otherwise, move forward and update max.
 * 5. Reverse the list again to restore the original order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode removeNodes(ListNode head) {

        // Reverse so we can process from right to left
        head = reverse(head);

        // Maximum value seen so far
        int max = head.val;

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            // If next node is smaller than max, remove it
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } 
            else {
                // Keep the node and update max
                curr = curr.next;
                max = curr.val;
            }
        }

        // Reverse again to restore original order
        return reverse(head);
    }

    // Reverse a linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
```
