/*
 * Problem: 230. Kth Smallest Element in a BST
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Approach: 
 * 1. Inorder traversal of a BST gives values in sorted order.
 * 2. Maintain k as a mutable value using an integer array.
 * 3. Traverse the left subtree first.
 * 4. Decrease k when visiting the current node.
 * 5. When k becomes 0, the current node is the kth smallest element.
 * 6. If the answer is not found in the left subtree or current node,
 *    search in the right subtree.
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

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[]{k});
    }

    private int inorder(TreeNode root, int[] k) {

        if (root == null) return -1;

        // Search left subtree
        int left = inorder(root.left, k);

        if (left != -1) return left;

        // Visit current node
        k[0]--;

        if (k[0] == 0) {
            return root.val;
        }

        // Search right subtree
        return inorder(root.right, k);
    }
}
