/**
 * Problem: 199. Binary Tree Right Side View
 * Link: https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Approach:
 * 1. Use DFS and keep track of the current level.
 * 2. Visit the right subtree first, because we want the rightmost
 *    node visible at each level.
 * 3. If level >= ans.size(), it means this is the first node visited
 *    at this level, so add its value to the answer.
 * 4. Then recursively visit the right and left subtrees.
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
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        dfs(root, 0, ans);

        return ans;
    }

    private void dfs(TreeNode root, int level, ArrayList<Integer> ans) {

        // Base case
        if (root == null) {
            return;
        }

        // First node visited at this level
        // will be the rightmost node because
        // we visit right subtree first
        if (level >= ans.size()) {
            ans.add(root.val);
        }

        // Visit right first
        dfs(root.right, level + 1, ans);

        // Then visit left
        dfs(root.left, level + 1, ans);
    }
}
