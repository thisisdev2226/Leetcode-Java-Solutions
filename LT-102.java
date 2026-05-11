/**
 * Problem: 102. Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Approach:
 * - Use Breadth First Search (BFS) with a Queue.
 * - Traverse level by level.
 * - For each level:
 *      1. Store current queue size.
 *      2. Remove all nodes of that level.
 *      3. Add their values into a temporary list.
 *      4. Push left and right children into the queue.
 * - Add each level list into the final result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode front = q.remove();

                level.add(front.val);

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
