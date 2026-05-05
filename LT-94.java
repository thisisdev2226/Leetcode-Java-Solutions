/**
 * Problem: 94. Binary Tree Inorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Approach 1: Recursive (DFS)
 * - Follow Left → Root → Right order.
 * - Traverse left subtree, visit node, then traverse right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) (recursion stack in worst case skewed tree)
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        inorder(root.left, ans);   // Left
        ans.add(root.val);         // Root
        inorder(root.right, ans);  // Right
    }
}
