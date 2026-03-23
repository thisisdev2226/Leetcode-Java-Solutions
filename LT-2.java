/*
Problem: 2. Add Two Numbers
Link: https://leetcode.com/problems/add-two-numbers/

Approach: Simulation using Linked List
- Traverse both linked lists simultaneously.
- Add corresponding digits along with carry.
- Create a new node for each digit of the result.
- Maintain carry for sums greater than 9.
- After traversal, if carry remains, add a new node.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        return result.next;
    }
}
