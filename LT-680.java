/*
Problem: 680. Valid Palindrome II
Link: https://leetcode.com/problems/valid-palindrome-ii/

Approach:
- Use two pointers: one at the beginning and one at the end.
- If characters match, move both pointers inward.
- On the first mismatch, we are allowed to delete at most one character.
- Check both possibilities:
    1. Skip the left character.
    2. Skip the right character.
- If either remaining substring is a palindrome, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            // If characters do not match, try deleting
            // either the left or the right character.
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) ||
                       isPalindrome(s, i, j - 1);
            }

            i++;
            j--;
        }

        return true;
    }

    // Checks whether the substring from i to j is a palindrome
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
