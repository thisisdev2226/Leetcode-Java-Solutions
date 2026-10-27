/*
Problem: 430. Flatten a Multilevel Doubly Linked List
Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

Approach:
1. Traverse the doubly linked list using a temporary pointer.
2. Store `temp.next` in `t` so the original next node is not lost.
3. If `temp.child` exists, recursively flatten the child list.
4. Connect the current node to the flattened child list and update the `prev` pointer.
5. Move to the end of the flattened child list and connect it to the original next node.
6. Update the `prev` pointer of the original next node if it exists.
7. Set `temp.child = null` to remove the child pointer.
8. Continue traversal from the original next node stored in `t`.
9. Return the original head.

Time Complexity: O(n)
Space Complexity: O(d), where d is the maximum nesting depth due to recursion.
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;

        while (temp != null) {
            Node t = temp.next;

            if (temp.child != null) {
                Node c = flatten(temp.child);

                // Connect the current node to the child list
                temp.next = c;
                c.prev = temp;

                // Move to the end of the flattened child list
                while (c.next != null) {
                    c = c.next;
                }

                // Connect the child list to the original next node
                c.next = t;

                if (t != null) {
                    t.prev = c;
                }
            }

            // Remove the child pointer
            temp.child = null;

            // Continue with the original next node
            temp = t;
        }

        return head;
    }
}
