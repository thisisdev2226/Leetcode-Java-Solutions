/**
 * Problem: 108. Convert Sorted Array to Binary Search Tree
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Approach:
 * - Since the array is sorted, the middle element becomes the root
 *   to maintain height balance.
 * - Recursively:
 *      Left half  -> Left subtree
 *      Right half -> Right subtree
 * - This is similar to Binary Search recursion.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(log n)   // Recursive stack height
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

    public TreeNode helper(int[] nums, int lo, int hi) {

        // Base case
        if (lo > hi) return null;

        // Middle element becomes root
        int mid = lo + (hi - lo) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = helper(nums, lo, mid - 1);

        // Build right subtree
        root.right = helper(nums, mid + 1, hi);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }
}
