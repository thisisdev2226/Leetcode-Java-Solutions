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

    /**
     * Problem: 86. Partition List
     * Link: https://leetcode.com/problems/partition-list/
     *
     * Approach:
     * - Create two lists:
     *   1. Nodes < x
     *   2. Nodes >= x
     * - Traverse original list and distribute nodes
     * - Connect both lists
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for two lists
        ListNode dummy1 = new ListNode(-1); // smaller list
        ListNode dummy2 = new ListNode(-1); // greater/equal list

        // Tail pointers
        ListNode t1 = dummy1;
        ListNode t2 = dummy2;

        // Traversal pointer
        ListNode t = head;

        while (t != null) {

            if (t.val < x) {
                t1.next = t;
                t1 = t1.next;
            } else {
                t2.next = t;
                t2 = t2.next;
            }

            t = t.next;
        }

        // Important: break old links to avoid cycles
        t1.next = null;
        t2.next = null;

        // Connect both lists
        t1.next = dummy2.next;

        return dummy1.next;
    }
}
