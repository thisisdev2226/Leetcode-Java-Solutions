/**
 * Problem: 20. Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 *
 * Approach:
 * 1. Use a stack to keep track of expected closing brackets.
 * 2. For every opening bracket, push its corresponding closing bracket.
 * 3. For every closing bracket, check:
 *    - If stack is empty → invalid
 *    - If top of stack doesn't match → invalid
 * 4. At the end, stack should be empty for a valid string.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
