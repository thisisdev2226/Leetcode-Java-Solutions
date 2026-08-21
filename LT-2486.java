/*
Problem: 2486. Append Characters to String to Make Subsequence
Link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

Approach:
- Use two pointers:
  i -> traverses string s
  j -> traverses string t
- Whenever s.charAt(i) matches t.charAt(j), increment j.
- This means we found one character of t as a subsequence in s.
- After traversing s, the remaining characters in t
  (n - j) must be appended to s.

Time Complexity: O(m)
Space Complexity: O(1)
*/

class Solution {
    public int appendCharacters(String s, String t) {

        int m = s.length();
        int n = t.length();

        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        while (i < m && j < n) {

            // Match the current character of t in s
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }

            // Always move to the next character in s
            i++;
        }

        // Remaining characters of t need to be appended
        return n - j;
    }
}
