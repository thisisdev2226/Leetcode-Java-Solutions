/**
 * Problem: 98. Validate Binary Search Tree
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Approach:
 * - Use recursion with range validation.
 * - Each node must lie within a valid range (min, max).
 * - For left subtree → values must be less than current node.
 * - For right subtree → values must be greater than current node.
 * - Pass updated constraints while traversing.
 * - Use long instead of int to avoid overflow edge cases.
 *
 * Time Complexity: O(N)
 * - We visit each node exactly once.
 *
 * Space Complexity: O(H)
 * - Recursive stack space, where H is height of tree.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;

        // Check current node validity
        if (root.val <= min || root.val >= max) return false;

        // Validate left and right subtrees
        boolean leftSubtree = validate(root.left, min, root.val);
        boolean rightSubtree = validate(root.right, root.val, max);

        return leftSubtree && rightSubtree;
    }
}
