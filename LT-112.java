/**
 * LeetCode 112 - Path Sum
 * Link: https://leetcode.com/problems/path-sum/
 *
 * Approach:
 * - Use recursion (DFS) to traverse the tree.
 * - Subtract the current node's value from targetSum while moving downward.
 * - When a leaf node is reached, check if the remaining target equals the leaf value.
 * - If yes, a valid root-to-leaf path exists.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        // Leaf node check
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}
