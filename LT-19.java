/**
 * Problem: 19. Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Approach:
 * 1. Traverse the linked list to calculate its length.
 * 2. If n == length, remove the head node.
 * 3. Otherwise, move to the (length - n)th node (node before the target).
 * 4. Adjust pointers to remove the nth node from the end.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Find length of list
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: If we need to remove the first node (head)
        if (n == length) {
            return head.next;
        }

        // Step 3: Find the node just before the node to remove
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Step 4: Remove the nth node from end
        temp.next = temp.next.next;

        return head;
    }
}
