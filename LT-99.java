/**
 * Problem: 99. Recover Binary Search Tree
 * Link: https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Approach:
 * - Perform inorder traversal because inorder of BST should be sorted.
 * - Track previous node during traversal.
 * - If prev.val > current.val, then BST property is violated.
 * - First violation:
 *      first = prev
 * - For every violation:
 *      second = current
 * - After traversal, swap values of first and second nodes.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)   // Recursive stack height
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

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Detect violation in BST property
        if (prev != null && prev.val > root.val) {

            // First incorrect node
            if (first == null) {
                first = prev;
            }

            // Second incorrect node
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Swap values of misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
