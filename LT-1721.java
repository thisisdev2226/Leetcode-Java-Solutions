/*
Problem: 1721. Swapping Nodes in a Linked List
Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

Approach:
1. Initialize first = head and move it to the k-th node from the beginning.
2. Initialize second = head and temp = first.
3. Move temp to the end of the linked list while moving second
   one step at a time.
4. When temp reaches the last node, second will be the k-th
   node from the end.
5. Swap the values of first and second.
6. Return head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        // Move to k-th node from start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find k-th node from end
        ListNode second = head;
        ListNode temp = first;

        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Swap the values
        int val = first.val;
        first.val = second.val;
        second.val = val;

        return head;
    }
}
