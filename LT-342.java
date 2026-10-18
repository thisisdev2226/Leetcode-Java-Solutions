/*
 * Problem: 342. Power of Four
 * Link: https://leetcode.com/problems/power-of-four/
 *
 * Approach:
 * 1. If n <= 0, return false because powers of four are positive.
 * 2. If n == 1, return true because 4^0 = 1.
 * 3. If n is not divisible by 4, return false.
 * 4. Otherwise, recursively call the function with n / 4.
 * 5. Continue until a base case is reached.
 *
 * Time Complexity: O(log₄ n)
 * Space Complexity: O(log₄ n) due to the recursion stack.
 */

class Solution {
    public boolean isPowerOfFour(int n) {
        // Base case
        if (n <= 0) return false;
        if (n == 1) return true;

        // Self work
        if (n % 4 != 0) return false;

        // Recursive call
        return isPowerOfFour(n / 4);
    }
}
