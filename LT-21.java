/**
 * Problem: 21. Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Approach:
 * - Use recursion to compare nodes of both lists.
 * - Base case:
 *   → If one list is null, return the other.
 * - Recursive case:
 *   → Compare values of list1 and list2
 *   → Attach smaller node to result and recurse for remaining list
 *
 * Time Complexity: O(n + m)
 * - n = length of list1, m = length of list2
 *
 * Space Complexity: O(n + m)
 * - Due to recursion stack
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
