/*
Problem: 5. Longest Palindromic Substring
Link: https://leetcode.com/problems/longest-palindromic-substring/

Approach:
- Use Expand Around Center technique
- For each index, consider it as center for:
  1. Odd length palindrome (center at i)
  2. Even length palindrome (center between i-1 and i)
- Expand outward while characters match
- Track the longest palindrome substring found

Time Complexity: O(n^2)
Space Complexity: O(1)

*/

class Solution {
    public String longestPalindrome(String str) {

        if (str.length() <= 1) { // edge case
            return str;
        }

        String LPS = "";

        for (int i = 1; i < str.length(); i++) {

            // Odd length palindrome
            int low = i;
            int high = i;

            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // Even length palindrome
            low = i - 1;
            high = i;

            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }
}
