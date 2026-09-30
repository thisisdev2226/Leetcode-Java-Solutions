/*
Problem: 206. Reverse Linked List
Link: https://leetcode.com/problems/reverse-linked-list/

Approach:
1. Initialize three pointers:
   - prev = null (previous node)
   - curr = head (current node)
   - agla = null (stores the next node temporarily)

2. Traverse the linked list until curr becomes null.
3. Store curr.next in agla so that we don't lose the remaining list.
4. Reverse the current node's pointer by setting curr.next = prev.
5. Move prev to curr and curr to agla.
6. Repeat until all the links are reversed.
7. Return prev as the new head of the reversed linked list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode agla = null;

        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        return prev;
    }
}
