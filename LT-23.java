/**
 * Problem: 23. Merge k Sorted Lists
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Approach:
 * - Use Divide and Conquer strategy.
 * - Recursively split the list of linked lists into two halves.
 * - Merge each half and then combine them using mergeTwoLists.
 * - This reduces the problem to merging pairs of lists efficiently.
 *
 * Time Complexity: O(N log k)
 * - N = total number of nodes across all lists
 * - k = number of linked lists
 *
 * Space Complexity: O(log k)
 * - Due to recursion stack (divide step)
 * - Note: mergeTwoLists also uses recursion → worst-case O(N)
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

    // Main function
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    // Divide and Conquer
    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    // Merge 2 sorted lists (recursive)
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
