/**
 * Problem: 125. Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/
 *
 * Approach:
 * - Use two pointers:
 *   - One from the start
 *   - One from the end
 * - Ignore non-alphanumeric characters.
 * - Convert the string to lowercase for case-insensitive comparison.
 * - If characters do not match, return false.
 * - If all valid characters match, return true.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isPalindrome(String s) {

        int p1 = 0;
        int p2 = s.length() - 1;

        s = s.toLowerCase();

        while (p1 < p2) {

            char ch1 = s.charAt(p1);
            char ch2 = s.charAt(p2);

            // Skip non-alphanumeric characters from left
            if (!(ch1 >= 'a' && ch1 <= 'z' || ch1 >= '0' && ch1 <= '9')) {
                p1++;
                continue;
            }

            // Skip non-alphanumeric characters from right
            if (!(ch2 >= 'a' && ch2 <= 'z' || ch2 >= '0' && ch2 <= '9')) {
                p2--;
                continue;
            }

            // Compare characters
            if (ch1 != ch2) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }
}
