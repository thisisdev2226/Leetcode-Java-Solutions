/**
 * Problem: 235. Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Approach:
 * 1. If root matches p or q, return root.
 * 2. If p and q lie on opposite sides, root is the LCA.
 * 3. If both are smaller, search the left subtree.
 * 4. Otherwise, search the right subtree.
 *
 * Time Complexity: O(h), where h is the height of the BST.
 * Space Complexity: O(h) due to recursion.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If root itself is p or q, root is the LCA
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // If p and q lie on opposite sides of root
        if ((p.val < root.val && q.val > root.val) ||
            (q.val < root.val && p.val > root.val)) {
            return root;
        }

        // If both p and q are in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Otherwise, both are in the right subtree
        return lowestCommonAncestor(root.right, p, q);
    }
}
