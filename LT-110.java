/**
 * Problem: 110. Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 *
 * Approach:
 * 1. For every node, calculate:
 *      - Height of left subtree
 *      - Height of right subtree
 * 2. If the absolute difference between heights is greater than 1,
 *    the tree is not balanced.
 * 3. Recursively check the left and right subtrees as well.
 *
 * Time Complexity: O(N²)
 *   - height() is called repeatedly for every node.
 *
 * Space Complexity: O(H)
 *   - Recursive stack space, where H is tree height.
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

    public int height(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        int difference = Math.abs(leftHeight - rightHeight);

        if (difference > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
