/**
 * Problem: 24. Swap Nodes in Pairs
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Approach:
 * - Use a dummy node to simplify edge cases (especially head swapping).
 * - Maintain a pointer (d1) that always points to the node before the pair.
 * - For each pair:
 *      1. Identify two nodes (swap1, swap2)
 *      2. Adjust pointers to swap them:
 *          - swap1.next = swap2.next
 *          - swap2.next = swap1
 *          - d1.next = swap2
 *      3. Move d1 to swap1 (next pair position)
 * - Continue until less than 2 nodes remain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-6);
        dummy.next = head;
        ListNode d1 = dummy;

        while (d1.next != null && d1.next.next != null) {

            ListNode swap1 = d1.next;
            ListNode swap2 = d1.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;

            d1.next = swap2;
            d1 = swap1;
        }

        return dummy.next;
    }
}
