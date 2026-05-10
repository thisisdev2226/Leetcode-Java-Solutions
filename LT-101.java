/**
 * Problem: 101. Symmetric Tree
 * Link: https://leetcode.com/problems/symmetric-tree/
 * 
 * Approach:
 * - First invert the left subtree.
 * - Then compare the inverted left subtree with the right subtree.
 * - If both trees are identical, the tree is symmetric.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)   // Recursive stack space
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
        if (p == null && q == null) return true;

        // If one node is null and other is not
        if (p == null || q == null) return false;

        // Values should also match
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // Swap left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        // Invert left subtree
        root.left = invertTree(root.left);

        // Compare inverted left subtree with right subtree
        return isSameTree(root.left, root.right);
    }
}
