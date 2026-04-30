/**
 * Problem: 83. Remove Duplicates from Sorted List
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Approach:
 * - Since the list is sorted, duplicates will always be adjacent.
 * - Use two pointers:
 *      i -> last unique node
 *      j -> traversal pointer
 * - Move j forward while values are same (skip duplicates).
 * - When a new value is found:
 *      connect i.next = j
 *      move i to j
 * - Finally, set i.next = null to terminate the list.
 *
 * Time Complexity: O(n)
 * - Traverse the list once.
 *
 * Space Complexity: O(1)
 * - No extra space used.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;
        
        ListNode i = head;
        ListNode j = head;
        
        while(j != null){
            if(i.val == j.val) {
                j = j.next;
            } else {
                i.next = j;
                i = j;
            }
        }

        i.next = j;  // j is null here, ensures proper termination
        return head;
    }
}
