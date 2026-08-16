/*
 * Problem: 2696. Minimum String Length After Removing Substrings
 * Link: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 *
 * Approach:
 * - Use a Stack to simulate the string after removals.
 * - If the current character forms "AB" or "CD" with the stack top,
 *   remove the top character instead of pushing the current character.
 * - Otherwise, push the current character.
 * - At the end, the stack size is the minimum possible length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!st.isEmpty() &&
                ((st.peek() == 'A' && c == 'B') ||
                 (st.peek() == 'C' && c == 'D'))) {

                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.size();
    }
}
