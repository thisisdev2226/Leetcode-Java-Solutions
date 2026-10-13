/*
Problem: 783. Minimum Distance Between BST Nodes
Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

Approach:
1. Perform inorder traversal of the BST. Inorder traversal visits nodes in sorted order.
2. Maintain a prev pointer to store the previously visited node.
3. If prev is not null, calculate the absolute difference between the current node and prev.
4. Update mindiff with the minimum difference found so far.
5. Reset mindiff and prev inside minDiffInBST() to handle multiple test cases correctly.

Time Complexity: O(n)
Space Complexity: O(h), where h is the height of the BST due to recursion.
*/

class Solution {

    static int mindiff = Integer.MAX_VALUE;
    static TreeNode prev = null;

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Visit the left subtree
        inorder(root.left);

        // Compare the current node with the previous node
        if (prev != null) {
            int diff = Math.abs(root.val - prev.val);
            mindiff = Math.min(diff, mindiff);
        }

        // Update prev to the current node
        prev = root;

        // Visit the right subtree
        inorder(root.right);
    }

    public int minDiffInBST(TreeNode root) {

        // Reset values before processing a new tree
        mindiff = Integer.MAX_VALUE;
        prev = null;

        inorder(root);

        return mindiff;
    }
}
