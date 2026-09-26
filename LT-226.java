/**
 * Problem: 226. Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 *
 * Approach:
 * 1. If the current node is null, return null.
 * 2. Swap the left and right children of the current node.
 * 3. Recursively invert the left subtree.
 * 4. Recursively invert the right subtree.
 * 5. Return the root after all nodes have been inverted.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 *
 * Where:
 * - N = number of nodes
 * - H = height of the tree
 * - O(H) space is used by the recursion stack.
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

    public TreeNode invertTree(TreeNode root) {

        // Base case: empty tree
        if (root == null) {
            return null;
        }

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert left subtree
        invertTree(root.left);

        // Invert right subtree
        invertTree(root.right);

        return root;
    }
}
