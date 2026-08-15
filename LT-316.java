/*
 * Problem: 316. Remove Duplicate Letters
 * Link: https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Approach:
 * - Use StringBuilder as a stack.
 * - lastIdx[] stores the last occurrence of each character.
 * - taken[] tells whether a character is already present in result.
 *
 * For every character:
 * 1. If the character is already taken, skip it.
 * 2. Otherwise, compare it with the last character of result.
 * 3. If the current character is smaller AND the last character
 *    appears again later, remove the last character.
 * 4. Add the current character to result and mark it as taken.
 *
 * Why do we remove the last character?
 * - We want the lexicographically smallest result.
 * - We can safely remove the last character only when it appears
 *   again later, so we won't lose that character permanently.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  // fixed-size arrays of 26
 */

class Solution {
    public String removeDuplicateLetters(String s) {
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

            // Already present in result
            if (taken[idx]) {
                continue;
            }

            // Remove larger characters if they occur again later
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
