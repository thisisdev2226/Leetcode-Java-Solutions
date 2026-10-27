/*
Problem: 2130. Maximum Twin Sum of a Linked List
Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

Approach:
1. Use slow and fast pointers to find the start of the second half of the linked list.
2. Reverse the second half using an iterative reverse function.
3. Initialize two pointers: p1 at the head and p2 at the reversed second half.
4. Traverse both halves simultaneously and calculate the twin sum (p1.val + p2.val).
5. Update maxSum whenever a larger twin sum is found.
6. Return maxSum after processing all twin pairs.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    // Reverse the linked list iteratively
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null;

        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        return prev;
    }

    public int pairSum(ListNode head) {

        // Find the start of the second half
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        slow = reverse(slow);

        // Compare twin pairs and find the maximum sum
        int maxSum = 0;
        ListNode p1 = head;
        ListNode p2 = slow;

        while (p2 != null) {
            int sum = p1.val + p2.val;

            if (maxSum < sum) {
                maxSum = sum;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return maxSum;
    }
}
