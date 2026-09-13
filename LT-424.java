/*
Problem: 424. Longest Repeating Character Replacement
Link: https://leetcode.com/problems/longest-repeating-character-replacement/

Approach:
- Use a sliding window with two pointers: left and right.
- Maintain frequency of each character using a frequency array.
- maxFreq stores the highest frequency of any character in the current window.
- Characters to replace = windowSize - maxFreq.
- If replacements > k, shrink the window from the left.
- Track the maximum valid window length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            int idx = s.charAt(right) - 'A';
            freq[idx]++;

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq, freq[idx]);

            // Characters that need to be replaced
            while ((right - left + 1) - maxFreq > k) {

                // Remove left character
                freq[s.charAt(left) - 'A']--;

                left++;
            }

            // Update maximum valid window
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
