/*
Problem: 237. Delete Node in a Linked List
Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

Approach:
1. We are given the node to delete, not the head of the linked list.
2. Since we cannot access the previous node, copy the value of the next node into the current node.
3. Update the current node's next pointer to skip the next node.
4. In this way, the given node is effectively deleted from the linked list.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
