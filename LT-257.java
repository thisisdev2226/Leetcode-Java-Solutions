/**
 * Problem: 257. Binary Tree Paths
 * Link: https://leetcode.com/problems/binary-tree-paths/
 *
 * Approach:
 * 1. Use DFS recursion to traverse every root-to-leaf path.
 * 2. Keep the current path in a String `s`.
 * 3. For a normal node, append `root.val + "->"` and recursively
 *    explore both left and right subtrees.
 * 4. When a leaf node is reached, append its value to `s` and
 *    add the complete path to the answer list.
 * 5. Return the list containing all root-to-leaf paths.
 *
 * Time Complexity: O(N * H)
 * Space Complexity: O(H)
 *
 * Where:
 * - N = number of nodes
 * - H = height of the tree
 * - O(N * H) because creating/copying strings for paths can
 *   take O(H) for each of the O(N) nodes in the worst case.
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

    public void helper(TreeNode root, List<String> ans, String s) {

        // If node is null, there is nothing to process
        if (root == null) {
            return;
        }

        // Leaf node -> complete root-to-leaf path found
        if (root.left == null && root.right == null) {

            // Add leaf value to the current path
            s += root.val;

            // Store the complete path
            ans.add(s);

            return;
        }

        // Normal node -> continue towards left subtree
        helper(root.left, ans, s + root.val + "->");

        // Normal node -> continue towards right subtree
        helper(root.right, ans, s + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        // Start DFS with an empty path
        helper(root, ans, "");

        return ans;
    }
}
