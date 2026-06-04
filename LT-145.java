/**
 * Problem: 145. Binary Tree Postorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Approach:
 * - Use Depth-First Search (DFS) recursion.
 * - Traverse the left subtree first.
 * - Then traverse the right subtree.
 * - Finally, add the current node's value to the result list.
 * - This follows the Postorder sequence: Left → Right → Root.
 *
 * Time Complexity: O(n)
 * - Each node is visited exactly once.
 *
 * Space Complexity: O(h)
 * - Recursive call stack where h is the height of the tree.
 * - Worst case: O(n) for a skewed tree.
 * - Best case: O(log n) for a balanced tree.
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
