/*
Problem: 647. Palindromic Substrings
Link: https://leetcode.com/problems/palindromic-substrings/

Approach:
1. Use the Expand Around Center technique to count all palindromic substrings.
2. Every palindrome has a center, so consider two cases:

   a) Odd-length palindrome:
      - Pass (i, i) as the left and right pointers.
      - Example: "aba", where 'b' is the center.

   b) Even-length palindrome:
      - Pass (i, i + 1) as the left and right pointers.
      - Example: "abba", where the center is between the two 'b's.

3. In the countPalindrome() method:
   - Check whether left and right are within valid boundaries.
   - Check whether both characters are equal.
   - If they match, increment count because we found a palindrome.
   - Expand outward by decreasing left and increasing right.
   - Continue until the characters don't match or boundaries are crossed.

4. Add the counts of odd-length and even-length palindromes for every index.

5. Return the total count.

Time Complexity: O(n²)
- We consider 2 possible centers for every index.
- In the worst case, each expansion takes O(n) time.

Space Complexity: O(1)
- Only a few variables are used.
- No extra data structure is required.
*/

class Solution {

    public int countPalindrome(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Count palindromes with odd length
            count += countPalindrome(s, i, i);

            // Count palindromes with even length
            count += countPalindrome(s, i, i + 1);
        }

        return count;
    }
}
