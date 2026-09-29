/**

* Problem: 203. Remove Linked List Elements
* Link: https://leetcode.com/problems/remove-linked-list-elements/
*
* Approach:
* 1. Create a dummy node and point it to the head.
* 2. Use a temp pointer starting from the dummy node.
* 3. Traverse the linked list while temp and temp.next are not null.
* 4. If temp.next.val == val:
* * Skip the current node by updating temp.next.
* * Do not move temp, as the next node may also have the same value.
* 5. Otherwise, move temp to temp.next.
* 6. Return dummy.next as the updated head.
*
* Time Complexity: O(n)
* Space Complexity: O(1)
  */

class Solution {
public ListNode removeElements(ListNode head, int val) {
if (head == null) return null;

    // Dummy node handles cases where the head needs to be removed
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode temp = dummy;

    while (temp != null && temp.next != null) {
        if (temp.next.val == val) {
            // Remove the next node
            temp.next = temp.next.next;
        } else {
            // Move forward only when the node is not removed
            temp = temp.next;
        }
    }

    return dummy.next;
}
}
