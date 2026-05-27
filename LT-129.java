/**
 * Problem: 129. Sum Root to Leaf Numbers
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Approach:
 * - Use DFS traversal.
 * - Maintain the current number formed from root to current node.
 * - At each node:
 *      currentSum = currentSum * 10 + node.val
 * - When a leaf node is reached, return the formed number.
 * - Return the sum of left and right subtree results.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where:
 * - n = number of nodes
 * - h = height of tree (recursion stack)
 */

class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currentSum) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Form current number
        currentSum = currentSum * 10 + root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Sum from left and right subtree
        return dfs(root.left, currentSum)
             + dfs(root.right, currentSum);
    }
}
