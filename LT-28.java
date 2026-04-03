/**
 * Problem: 28. Find the Index of the First Occurrence in a String
 * Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Approach:
 * - Use a sliding window over the main string (haystack)
 * - For each index i, check if substring starting at i matches needle
 * - Compare characters one by one
 * - If all characters match → return index i
 * - If no match found → return -1
 *
 * Time Complexity: O(n * m)
 * - n = length of haystack
 * - m = length of needle
 *
 * Space Complexity: O(1)
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) return i;
        }

        return -1;
    }
}
