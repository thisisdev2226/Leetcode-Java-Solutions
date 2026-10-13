/*
Problem: 1305. All Elements in Two Binary Search Trees
Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

Approach:
1. Perform inorder traversal of both BSTs using Morris Traversal to get sorted lists.
2. Morris Traversal uses threaded links to achieve O(1) auxiliary space, excluding the lists.
3. Merge the two sorted lists using two pointers, similar to the merge step of Merge Sort.
4. Add the remaining elements of either list after one list is exhausted.

Time Complexity: O(n + m)
Space Complexity: O(n + m) for the two lists and the result.
*/

class Solution {

    // Merge two sorted lists into one sorted list
    public void merge(List<Integer> a, List<Integer> b,
                      List<Integer> ans) {

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {

            if (a.get(i) < b.get(j)) {
                ans.add(a.get(i));
                i++;
            } else {
                ans.add(b.get(j));
                j++;
            }
        }

        // Add remaining elements of list b
        while (j < b.size()) {
            ans.add(b.get(j));
            j++;
        }

        // Add remaining elements of list a
        while (i < a.size()) {
            ans.add(a.get(i));
            i++;
        }
    }

    public List<Integer> getAllElements(TreeNode root1,
                                        TreeNode root2) {

        // Store elements of the first BST in sorted order
        List<Integer> a = new ArrayList<>();
        TreeNode curr = root1;

        while (curr != null) {

            if (curr.left != null) {

                // Find the inorder predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {

                    // Create a temporary threaded link
                    pred.right = curr;
                    curr = curr.left;

                } else {

                    // Remove the threaded link and visit the node
                    pred.right = null;
                    a.add(curr.val);
                    curr = curr.right;
                }

            } else {

                // No left subtree, so visit the current node
                a.add(curr.val);
                curr = curr.right;
            }
        }

        // Store elements of the second BST in sorted order
        List<Integer> b = new ArrayList<>();
        curr = root2;

        while (curr != null) {

            if (curr.left != null) {

                // Find the inorder predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {

                    // Create a temporary threaded link
                    pred.right = curr;
                    curr = curr.left;

                } else {

                    // Remove the threaded link and visit the node
                    pred.right = null;
                    b.add(curr.val);
                    curr = curr.right;
                }

            } else {

                // No left subtree, so visit the current node
                b.add(curr.val);
                curr = curr.right;
            }
        }

        // Merge both sorted lists
        List<Integer> ans = new ArrayList<>();
        merge(a, b, ans);

        return ans;
    }
}
