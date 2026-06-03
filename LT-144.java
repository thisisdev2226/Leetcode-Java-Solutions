/**
 * LeetCode 144 - Binary Tree Preorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Approach:
 * Use recursion to perform preorder traversal.
 * Preorder follows the order: Root -> Left -> Right.
 * Visit the current node, then recursively traverse
 * the left subtree followed by the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * (Includes recursion stack and output list)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
