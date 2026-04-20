/*
📌 Problem: 58. Length of Last Word
🔗 Link: https://leetcode.com/problems/length-of-last-word/

💡 Approach:
1. Remove trailing spaces using trim().
2. Traverse the string from the end.
3. Count characters until a space is encountered.
4. Return the count.

⏱ Time Complexity: O(n)
🗂 Space Complexity: O(1)   // ignoring string copy from trim()
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;

        // Remove trailing spaces
        String str = s.trim();

        // Traverse from end
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
