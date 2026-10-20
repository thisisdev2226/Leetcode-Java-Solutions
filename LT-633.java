/**
 * Problem: 633. Sum of Square Numbers
 * Link: https://leetcode.com/problems/sum-of-square-numbers/
 *
 * Approach:
 * 1. If c is negative, return false because squares cannot sum to a negative number.
 * 2. Initialize two pointers:
 *    - left = 0
 *    - right = sqrt(c)
 * 3. Calculate sum = left * left + right * right.
 * 4. If sum == c, return true.
 * 5. If sum < c, increment left to increase the sum.
 * 6. If sum > c, decrement right to decrease the sum.
 * 7. If the pointers cross without finding a match, return false.
 *
 * Time Complexity: O(sqrt(c))
 * Space Complexity: O(1)
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        // Two pointers
        long left = 0;
        long right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
