/*
Problem: 450. Delete Node in a BST
Link: https://leetcode.com/problems/delete-node-in-a-bst/

Approach:
1. If the current node is null, return null.
2. If key is smaller than root.val, search and delete in the left subtree.
3. If key is greater than root.val, search and delete in the right subtree.
4. If the node is found:
   - Leaf node: return null.
   - One child: return the non-null child.
   - Two children: find the inorder predecessor (largest node in the left subtree), copy its value to the current node, and delete the predecessor from the left subtree.
5. Return the updated root.

Time Complexity: O(h), where h is the height of the BST.
Space Complexity: O(h), due to recursive call stack.

*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case: node does not exist
        if (root == null) {
            return null;
        }

        // Search in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node with the given key is found
        else {

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Find inorder predecessor: largest value in left subtree
            TreeNode predecessor = findPredecessor(root.left);

            // Replace current node's value with predecessor's value
            root.val = predecessor.val;

            // Delete the predecessor from the left subtree
            root.left = deleteNode(root.left, predecessor.val);
        }

        return root;
    }

    // Returns the rightmost node of the given subtree
    private TreeNode findPredecessor(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }
}
