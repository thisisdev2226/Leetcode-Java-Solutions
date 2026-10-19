/*
Problem: 344. Reverse String
Link: https://leetcode.com/problems/reverse-string/

Approach:
1. Initialize two pointers: left = 0 and right = s.length - 1.
2. Run a while loop while left < right.
3. Swap the characters at the left and right indices using a temporary variable.
4. Increment left and decrement right to move toward the center.
5. Stop when both pointers meet or cross. The string is reversed in-place.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }
}
