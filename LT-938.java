/**
 * Problem: 938. Range Sum of BST
 * Link: https://leetcode.com/problems/range-sum-of-bst/
 *
 * Approach:
 * 1. If root is null, return 0.
 * 2. If root.val is smaller than low, then all values in the left
 *    subtree are also smaller than low, so only explore the right subtree.
 * 3. If root.val is greater than high, then all values in the right
 *    subtree are also greater than high, so only explore the left subtree.
 * 4. If root.val lies within [low, high], include it in the sum and
 *    explore both left and right subtrees.
 *
 * Time Complexity: O(n) in the worst case.
 * Space Complexity: O(h), where h is the height of the BST due to recursion.
 *
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
    public int rangeSumBST(TreeNode root, int low, int high) {

        // Base case
        if (root == null) {
            return 0;
        }

        // root.val is smaller than low → go right
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // root.val is greater than high → go left
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // root.val is within range → include it and explore both sides
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
