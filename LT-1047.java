/*
 * Problem: 1047. Remove All Adjacent Duplicates In String
 *
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Approach:
 * - Use StringBuilder as a stack.
 * - Traverse each character of the string.
 * - If the current character is the same as the last character
 *   in the StringBuilder, remove the last character.
 * - Otherwise, append the current character.
 * - Finally, return the StringBuilder as a string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeDuplicates(String s) {
        
        // StringBuilder acts like a stack
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            
            int len = stack.length();

            // If last character is same as current,
            // remove the last character
            if (len > 0 && stack.charAt(len - 1) == ch) {
                stack.deleteCharAt(len - 1);
            } 
            else {
                // Otherwise, add current character
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}
