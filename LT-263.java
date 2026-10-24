/*
Problem: 263. Ugly Number
Link: https://leetcode.com/problems/ugly-number/

Approach:
1. If n <= 0, return false because ugly numbers must be positive.
2. Divide n by 2 repeatedly while it is divisible by 2.
3. Divide n by 3 repeatedly while it is divisible by 3.
4. Divide n by 5 repeatedly while it is divisible by 5.
5. If n becomes 1, return true; otherwise, return false.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) {
            n = n / 2;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }

        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }
}
