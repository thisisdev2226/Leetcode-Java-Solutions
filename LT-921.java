/**
 * Problem: 921. Minimum Add to Make Parentheses Valid
 * Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Approach:
 * 1. Use a stack to store unmatched parentheses.
 * 2. If the current character is '(', push it onto the stack.
 * 3. If the current character is ')':
 *    - If the stack is empty or the top is ')', push ')' because it has no matching '('.
 *    - Otherwise, pop '(' because the pair is valid.
 * 4. Return the stack size, which represents the minimum number of parentheses to add.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty() || st.peek() == ')') {
                    st.push(ch);
                } else {
                    st.pop();
                }
            }
        }

        return st.size();
    }
}
