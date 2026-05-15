/**
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Approach:
 * - Preorder traversal gives the root node first.
 * - Store inorder indices in a HashMap for O(1) lookup.
 * - Recursively construct:
 *      Left subtree  -> inorder left side
 *      Right subtree -> inorder right side
 * - This removes the O(n) search in inorder array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode build(int[] preorder, int left, int right) {

        if (left > right) return null;

        // Current preorder element is root
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder using HashMap
        int idx = map.get(rootVal);

        // Build left subtree
        root.left = build(preorder, left, idx - 1);

        // Build right subtree
        root.right = build(preorder, idx + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }
}
