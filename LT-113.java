/*
Problem: 113. Path Sum II
Link: https://leetcode.com/problems/path-sum-ii/

Approach:
- Use DFS + Backtracking.
- Maintain a current path list while traversing the tree.
- At each node:
    1. Add current node value to path.
    2. Reduce targetSum by current node value.
- When a leaf node is reached:
    - If remaining target becomes equal to node value,
      store the current path into answer.
- Backtrack by removing the last added node after recursive calls.

Time Complexity: O(N^2)
- In worst case, copying paths into answer takes extra O(N).

Space Complexity: O(H)
- Recursive stack + path list.
- H = height of tree.
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

    public void helper(List<List<Integer>> ans,
                       List<Integer> arr,
                       TreeNode root,
                       int targetSum) {

        if (root == null) return;

        // Leaf node
        if (root.left == null && root.right == null) {

            arr.add(root.val);

            if (root.val == targetSum) {

                List<Integer> path = new ArrayList<>();

                for (int i = 0; i < arr.size(); i++) {
                    path.add(arr.get(i));
                }

                ans.add(path);
            }

            arr.remove(arr.size() - 1); // backtracking
            return;
        }

        // Add current node
        arr.add(root.val);

        helper(ans, arr, root.left, targetSum - root.val);
        helper(ans, arr, root.right, targetSum - root.val);

        // Backtracking
        arr.remove(arr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        helper(ans, arr, root, targetSum);

        return ans;
    }
}
