/**
 * Problem: 13. Roman to Integer
 * Link: https://leetcode.com/problems/roman-to-integer/
 *
 * Approach:
 * - Traverse the string from left to right.
 * - If the current value is less than the next value, subtract it.
 * - Otherwise, add it to the result.
 * - This handles cases like IV (4), IX (9), etc.
 *
 * Time Complexity: O(n)
 * - We iterate through the string once.
 *
 * Space Complexity: O(1)
 * - No extra space is used apart from variables.
 */

class Solution {

    public int getVal(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int curr = getVal(s.charAt(i));

            if (i + 1 < n && curr < getVal(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum;
    }
}
