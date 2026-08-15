/*
 * Problem: 1081. Smallest Subsequence of Distinct Characters
 * Link: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Approach:
 * - Use StringBuilder as a stack.
 * - lastIdx[] stores the last occurrence of every character.
 * - taken[] tells whether a character is already present in the result.
 * - For every character:
 *      1. Skip it if it is already taken.
 *      2. While the current character is smaller than the stack's top
 *         and the top character appears again later, remove the top.
 *      3. Add the current character to the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  // Arrays are of fixed size 26
 */

class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        // Using StringBuilder as a stack
        StringBuilder result = new StringBuilder();

        boolean[] taken = new boolean[26];

        // Stores the last occurrence of each character
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);

        // Find last occurrence of every character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }

        // Process each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            // Character is already present in result
            if (taken[idx]) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (result.length() > 0
                    && ch < result.charAt(result.length() - 1)
                    && lastIdx[result.charAt(result.length() - 1) - 'a'] > i) {

                char removed = result.charAt(result.length() - 1);

                taken[removed - 'a'] = false;

                result.deleteCharAt(result.length() - 1);
            }

            // Add current character
            result.append(ch);
            taken[idx] = true;
        }

        return result.toString();
    }
}
