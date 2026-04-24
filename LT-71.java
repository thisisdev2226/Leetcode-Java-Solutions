/**
 * Problem: 71. Simplify Path
 * Link: https://leetcode.com/problems/simplify-path/
 *
 * Approach:
 * - Split the path using "/" to process each directory.
 * - Use a Stack to simulate directory traversal:
 *   1. Ignore "" (empty) and "." (current directory).
 *   2. If ".." → go back to parent directory (pop from stack if not empty).
 *   3. Otherwise → push valid directory name into stack.
 *
 * - Build the final path:
 *   - Join stack elements with "/" prefix.
 *   - If stack is empty → return "/".
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();
        String[] arr = path.split("/");

        for (String i : arr) {
            if (i.equals("..") && !st.isEmpty()) {
                st.pop();
            } else if (!i.equals("") && !i.equals(".") && !i.equals("..")) {
                st.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
