/*
Problem: 567. Permutation in String
Link: https://leetcode.com/problems/permutation-in-string/
Approach: Sliding Window + Frequency Count
Time Complexity: O(26 * n) ≈ O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        // Frequency of s1
        for (int i = 0; i < n; i++) {
            s1_freq[s1.charAt(i) - 'a']++;
        }

        int i = 0, j = 0;

        while (j < m) {
            // Add current character to window
            s2_freq[s2.charAt(j) - 'a']++;

            // Maintain window size
            if (j - i + 1 > n) {
                s2_freq[s2.charAt(i) - 'a']--;
                i++;
            }

            // Compare both frequency arrays
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }

            j++;
        }

        return false;
    }
}
