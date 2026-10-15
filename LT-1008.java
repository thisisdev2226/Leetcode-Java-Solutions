/**
 * Problem: 1008. Construct Binary Search Tree from Preorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * Approach:
 * 1. Take the first element as the root.
 * 2. Insert every remaining element into the BST.
 * 3. Return the constructed BST.
 *
 * Time Complexity: Average O(n log n), Worst O(n^2)
 * Space Complexity: O(n) for the tree and O(n) recursion stack
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

    // Inserts a value into its correct position in the BST
    public TreeNode insertInBst(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertInBst(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertInBst(root.right, val);
            }
        }

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // First element becomes the root
        TreeNode root = new TreeNode(preorder[0]);

        // Insert the remaining elements one by one
        for (int i = 1; i < preorder.length; i++) {
            root = insertInBst(root, preorder[i]);
        }

        return root;
    }
}
