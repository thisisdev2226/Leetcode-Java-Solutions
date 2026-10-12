/*
Problem: 669. Trim a Binary Search Tree
Link: https://leetcode.com/problems/trim-a-binary-search-tree/

Approach:
1. If root is null, return null because there is no node to process.
2. Recursively trim the left and right subtrees so that all remaining nodes satisfy the range [low, high].
3. If root.val < low, discard the current node and its left subtree, and return root.right because all left subtree values are smaller.
4. If root.val > high, discard the current node and its right subtree, and return root.left because all right subtree values are greater.
5. If root.val lies within [low, high], keep the current node with its trimmed children and return root.

Time Complexity: O(n), where n is the number of nodes in the tree.
Space Complexity: O(h), where h is the height of the tree due to the recursive call stack.
*/

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Trim the left and right subtrees recursively
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // If the current value is smaller than low,
        // discard this node and its left subtree
        if (root.val < low) {
            return root.right;
        }

        // If the current value is greater than high,
        // discard this node and its right subtree
        if (root.val > high) {
            return root.left;
        }

        // The current node is within the valid range
        return root;
    }
}
