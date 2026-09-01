/*
    Problem: 438. Find All Anagrams in a String
    Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

    Approach:
    - Use Sliding Window of size equal to the length of string p.
    - Store frequency of characters of p in an array.
    - Expand the window character by character.
    - If the window size exceeds p.length(), remove the left character.
    - Whenever the frequency arrays match, add the starting index to the result.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to window
            windowFreq[s.charAt(right) - 'a']++;

            // Maintain window size
            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            // Check if current window is an anagram
            if (right - left + 1 == p.length()
                    && Arrays.equals(pFreq, windowFreq)) {
                result.add(left);
            }
        }

        return result;
    }
}
