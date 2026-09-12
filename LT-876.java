/*
Problem: 876. Middle of the Linked List
Link: https://leetcode.com/problems/middle-of-the-linked-list/

Approach:

* Use the Slow and Fast Pointer technique.
* `slow` moves one step at a time.
* `fast` moves two steps at a time.
* When `fast` reaches the end, `slow` is at the middle.
* For an even-length list, this returns the right middle node.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
public ListNode middleNode(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;       // moves 1 step
        fast = fast.next.next;  // moves 2 steps
    }

    return slow;
}

}
