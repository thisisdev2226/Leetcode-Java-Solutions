/**
 * Problem: 701. Insert into a Binary Search Tree
 * Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Approach:
 * 1. If the current root is null, create and return a new node with the given value.
 * 2. If val is smaller than root.val, recursively insert into the left subtree.
 * 3. Otherwise, recursively insert into the right subtree.
 * 4. Return the root so that the tree structure is maintained.
 *
 * Time Complexity: O(h), where h is the height of the BST.
 * Space Complexity: O(h) due to the recursion stack.
 *
 * For a balanced BST: O(log n)
 * For a skewed BST: O(n)
 *
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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If we reach a null position, insert the new node here
        if (root == null) {
            return new TreeNode(val);
        }

        // Insert into the left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // Insert into the right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the root of the BST
        return root;
    }
}
