/*
 * Problem: 1038. Binary Search Tree to Greater Sum Tree
 * Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Approach: 
 * 1. Perform reverse inorder traversal: Right -> Root -> Left.
 * 2. In a BST, reverse inorder visits nodes in decreasing order.
 * 3. Maintain a running sum of all previously visited larger values.
 * 4. Add the running sum to the current node's value.
 * 5. Update sum and continue with the left subtree.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
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

    int sum = 0;

    public void helper(TreeNode root) {

        if (root == null) return;

        // Right subtree
        helper(root.right);

        // Add current value to sum
        sum += root.val;
        root.val = sum;

        // Left subtree
        helper(root.left);
    }

    public TreeNode convertBST(TreeNode root) {

        helper(root);

        return root;
    }
}
