/*
 * Problem: 1249. Minimum Remove to Make Valid Parentheses
 * Link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Approach:
 * 1. Use a stack to store the indexes of unmatched parentheses.
 * 2. If the current character is '(', push its index onto the stack.
 * 3. If the current character is ')':
 *    - If the stack is empty or the top index points to ')', push its index.
 *    - Otherwise, pop the matching '(' index.
 * 4. Traverse the string from right to left.
 * 5. Skip characters whose indexes are present at the top of the stack.
 * 6. Append the remaining characters and reverse the StringBuilder.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        // Find indexes of invalid parentheses
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty() || s.charAt(st.peek()) == ')') {
                    st.push(i);
                } else {
                    st.pop();
                }
            }
        }

        // Build the string by skipping invalid indexes
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (!st.isEmpty() && st.peek() == i) {
                st.pop();
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }
}
