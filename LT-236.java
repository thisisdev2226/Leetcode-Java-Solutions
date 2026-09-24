/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Approach:
 * 1. If root is null, or root is either p or q, return root.
 * 2. Recursively search for p and q in the left and right subtrees.
 * 3. If both left and right return a non-null node, p and q are found
 *    in different subtrees, so the current root is the LCA.
 * 4. Otherwise, return whichever side is non-null.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case:
        // If root is null, or root is p/q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides found a node,
        // current root is the Lowest Common Ancestor
        if (left != null && right != null) {
            return root;
        }

        // Return the side where p or q was found
        return left != null ? left : right;
    }
}
