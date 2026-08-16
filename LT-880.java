/*
 * Problem: 880. Decoded String at Index
 * Link: https://leetcode.com/problems/decoded-string-at-index/
 *
 * Approach:
 * - First calculate the length of the decoded string without actually
 *   constructing it.
 * - Letters increase the decoded length by 1.
 * - A digit multiplies the current decoded length.
 * - Then traverse the string backwards.
 * - Use k % size to map k back to the previous smaller string.
 * - When k becomes 0 at a letter, that letter is the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long size = 0;

        // Calculate decoded string length
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                size *= (ch - '0');
            } else {
                size += 1;
            }
        }

        // Traverse backwards
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            k = (int) (k % size);

            if (k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                size -= 1;
            }
        }

        return "";
    }
}
