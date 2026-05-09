/**
 * Problem: 100. Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 * 
 * Approach:
 * - Use recursion to compare both trees node by node.
 * - If both nodes are null, return true.
 * - If one node is null and the other is not, return false.
 * - If values of current nodes are different, return false.
 * - Recursively check left subtrees and right subtrees.
 * - Both left and right comparisons must be true for trees to be identical.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *   - h is the height of the tree (recursive stack space)
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null, trees are same till this point
        if (p == null && q == null) return true;

        // If one node is null and the other is not
        if (p == null || q == null) return false;

        // If current node values are different
        if (p.val != q.val) return false;

        // Check both left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
