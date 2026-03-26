/**
 * Problem: 7. Reverse Integer
 * Link: https://leetcode.com/problems/reverse-integer/
 *
 * Approach:
 * - Extract digits one by one using modulus (% 10)
 * - Build reversed number by multiplying previous result by 10 and adding digit
 * - Before adding digit, check for overflow:
 *      if rev > Integer.MAX_VALUE/10 OR rev < Integer.MIN_VALUE/10 → return 0
 *
 * Time Complexity: O(log₁₀ n)  // number of digits
 * Space Complexity: O(1)
 */

class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = (rev * 10) + digit;
            x = x / 10;
        }

        return rev;
    }
}
