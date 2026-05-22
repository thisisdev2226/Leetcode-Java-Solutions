/*
Problem: 114. Flatten Binary Tree to Linked List
Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Approach:
- Use Morris Traversal style modification.
- For every node:
    1. If left subtree exists, find its rightmost node
       (predecessor).
    2. Connect predecessor's right to current node's right subtree.
    3. Move left subtree to right side.
    4. Set left = null.
- Move to next node using curr.right.

Time Complexity: O(N)
- Every node is visited at most twice.

Space Complexity: O(1)
- No extra space used.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            // If left subtree exists
            if (curr.left != null) {

                // Find predecessor (rightmost node of left subtree)
                TreeNode pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                // Connect predecessor with current right subtree
                pred.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move ahead
            curr = curr.right;
        }
    }
}
