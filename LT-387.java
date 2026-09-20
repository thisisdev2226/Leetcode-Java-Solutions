/*
Problem: 387. First Unique Character in a String
Link: https://leetcode.com/problems/first-unique-character-in-a-string/

Approach:
- Use an integer array of size 26 to store the frequency of each character.
- First pass: count the frequency of every character.
- Second pass: find the first character whose frequency is 1.
- Return its index. If no unique character exists, return -1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            freq[index]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
