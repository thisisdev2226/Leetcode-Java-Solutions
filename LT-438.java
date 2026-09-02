/*
 * Problem: 438. Find All Anagrams in a String
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Approach:
 * - Use the Sliding Window technique.
 * - Maintain two frequency arrays of size 26:
 *      1. pCount      -> frequency of characters in p
 *      2. windowCount -> frequency of characters in the current window of s
 * - The window size is always equal to p.length().
 * - Add the current character to windowCount.
 * - If the window becomes larger than p.length(), remove the leftmost character.
 * - Compare both frequency arrays using the matches() method.
 * - If all 26 frequencies are equal, the current window is an anagram of p.
 *
 * Time Complexity: O(26 * n) ≈ O(n)
 * Space Complexity: O(26) ≈ O(1)
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // If p is longer than s, an anagram is impossible
        if (p.length() > s.length()) {
            return result;
        }

        // Frequency of characters in p
        int[] pCount = new int[26];

        // Frequency of characters in current window of s
        int[] windowCount = new int[26];

        // Count frequency of each character in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        // Sliding Window
        for (int i = 0; i < s.length(); i++) {

            // Add current character to the window
            windowCount[s.charAt(i) - 'a']++;

            // If window size becomes greater than p.length(),
            // remove the leftmost character
            if (i >= windowSize) {
                windowCount[s.charAt(i - windowSize) - 'a']--;
            }

            // Check if current window is an anagram of p
            if (matches(pCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    // Checks whether both frequency arrays are equal
    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {

            // If even one frequency is different,
            // the window is not an anagram
            if (a[i] != b[i]) {
                return false;
            }
        }

        // All 26 frequencies are equal
        return true;
    }
}
