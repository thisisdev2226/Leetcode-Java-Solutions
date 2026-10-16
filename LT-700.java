/*
Problem: 700. Search in a Binary Search Tree
Link: https://leetcode.com/problems/search-in-a-binary-search-tree/

Approach:
1. If root is null, the value is not present. Return null.
2. If root.val equals val, return the current node.
3. If val is smaller than root.val, search in the left subtree.
4. Otherwise, search in the right subtree.
5. Return the node containing the target, or null if it does not exist.

Time Complexity: O(h), where h is the height of the BST.
Space Complexity: O(h), due to the recursive call stack.

*/

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        // Base case: tree is empty or value is not found
        if (root == null) {
            return null;
        }

        // Target found
        if (root.val == val) {
            return root;
        }

        // Target is smaller, search left
        else if (root.val > val) {
            return searchBST(root.left, val);
        }

        // Target is greater, search right
        else {
            return searchBST(root.right, val);
        }
    }
}
