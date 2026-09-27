/*
 * Problem: 590. N-ary Tree Postorder Traversal
 * Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * Approach:
 * 1. If the root is null, return.
 * 2. Traverse all children of the current node recursively.
 * 3. After visiting all children, add the current node's value to the result.
 * 4. This gives the order: Children -> Root, which is postorder traversal.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * N = total number of nodes
 * H = height of the N-ary tree (recursion stack)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        post(root, ans);

        return ans;
    }

    private void post(Node root, List<Integer> ans) {
        // Base case
        if (root == null) {
            return;
        }

        // Visit all children first
        for (int i = 0; i < root.children.size(); i++) {
            post(root.children.get(i), ans);
        }

        // Visit root after all children
        ans.add(root.val);
    }
}
