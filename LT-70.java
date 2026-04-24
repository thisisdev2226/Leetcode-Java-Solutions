/**
 * Problem: 70. Climbing Stairs
 * Link: https://leetcode.com/problems/climbing-stairs/
 *
 * Approach:
 * This problem follows the Fibonacci pattern.
 * At each step, you can either climb 1 or 2 steps.
 * So, total ways to reach step n = ways(n-1) + ways(n-2).
 *
 * We use Bottom-Up Dynamic Programming:
 * - Initialize base cases:
 *   dp[1] = 1, dp[2] = 2
 * - Build solution iteratively from 3 to n
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // Bottom-Up DP
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int state = 3; state <= n; state++) {
            dp[state] = dp[state - 1] + dp[state - 2];
        }

        return dp[n];
    }
}
