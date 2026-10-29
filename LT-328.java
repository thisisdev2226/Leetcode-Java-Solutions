/*
Problem: 328. Odd Even Linked List
Link: https://leetcode.com/problems/odd-even-linked-list/

Approach:
1. If the list is empty, return head.
2. Maintain two pointers:
   - odd: points to the odd-indexed nodes.
   - even: points to the even-indexed nodes.
3. Store the starting node of the even list in evenHead so we don't lose it.
4. Traverse the list and rearrange the next pointers:
   - Connect the current odd node to the next odd node.
   - Connect the current even node to the next even node.
5. After rearranging, connect the last odd node to evenHead.
6. Return head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        // Store the starting node of the even-indexed list
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // Connect odd-indexed nodes
            odd.next = odd.next.next;
            odd = odd.next;

            // Connect even-indexed nodes
            even.next = even.next.next;
            even = even.next;
        }

        // Attach the even-indexed list after the odd-indexed list
        odd.next = evenHead;

        return head;
    }
}
