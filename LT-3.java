/*
Problem: 3. Longest Substring Without Repeating Characters
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach:
- Use Sliding Window + HashSet
- Maintain a window [left, right]
- Expand right pointer and add characters to set
- If duplicate found, shrink window from left until duplicate is removed
- Track maximum window size

Time Complexity: O(n)
Space Complexity: O(k)  // k = size of character set (at most 26/128/256)

*/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Remove elements from left until duplicate is gone
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
