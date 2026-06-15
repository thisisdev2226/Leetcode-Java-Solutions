/**
 * Problem: 160. Intersection of Two Linked Lists
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Approach:
 * 1. Calculate the lengths of both linked lists.
 * 2. Move the pointer of the longer list ahead by the difference in lengths.
 * 3. Traverse both lists simultaneously until the nodes become equal.
 * 4. The first common node is the intersection point.
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lengthA = 0;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        int lengthB = 0;
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if (lengthA > lengthB) {
            int steps = lengthA - lengthB;
            for (int i = 0; i < steps; i++) {
                tempA = tempA.next;
            }
        } else {
            int steps = lengthB - lengthA;
            for (int i = 0; i < steps; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}
