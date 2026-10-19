/*
Problem: 231. Power of Two
Link: https://leetcode.com/problems/power-of-two/

Approach:
1. If n <= 0, return false because a power of two must be positive.
2. If n == 1, return true because 2^0 = 1.
3. If n is not divisible by 2, return false because it cannot be reduced to 1 by repeatedly dividing by 2.
4. Otherwise, recursively check n / 2 until a base case is reached.

Time Complexity: O(log n)
Space Complexity: O(log n) — recursion stack
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Base case
        if (n <= 0) return false;
        if (n == 1) return true;

        // Self work
        if (n % 2 != 0) return false;

        // Recursive work
        return isPowerOfTwo(n / 2);
    }
}
