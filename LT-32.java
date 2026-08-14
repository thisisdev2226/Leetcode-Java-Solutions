/*
 * Problem: 32. Longest Valid Parentheses
 * Link: https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Approach:
 * - Use a stack to store indices.
 * - Push -1 initially as a base index.
 * - For '(' -> push its index.
 * - For ')' -> pop the top index.
 * - If the stack becomes empty, push the current index as the new base.
 * - Otherwise, i - st.peek() gives the length of the current valid substring.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int longestValidParentheses(String s) {

        // Stack stores indices
        Stack<Integer> st = new Stack<>();

        // Base index for calculating length
        st.push(-1);

        int max = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);

            } else {

                // Try to match ')'
                st.pop();

                // No matching '('
                if (st.isEmpty()) {
                    st.push(i);
                } else {

                    // Current valid length
                    max = Math.max(max, i - st.peek());
                }
            }
        }

        return max;
    }
}
