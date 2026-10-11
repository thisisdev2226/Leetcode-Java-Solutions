/*
Problem: 509. Fibonacci Number
Link: https://leetcode.com/problems/fibonacci-number/

Approach:
1. Use Recursion + Memoization (Top-Down DP).
2. Base cases:
   - If n <= 1, return n.
3. Before making recursive calls, check whether dp[n] already contains the answer.
4. If the answer is not calculated, compute:
   fib(n - 1) + fib(n - 2)
5. Store the calculated answer in dp[n] and return it.

Time Complexity: O(n)
Space Complexity: O(n) for the DP array and recursion stack.
*/

class Solution {

    // Recursion + Memoization -> Top-Down DP

    public int fib(int n) {
        int[] dp = new int[n + 1];

        // Initialize all values with -1.
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {

        // Base cases.
        if (n <= 1) {
            return n;
        }

        // Check whether the answer is already calculated.
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate the answer using recursion.
        int ans = helper(n - 1, dp) + helper(n - 2, dp);

        // Store the answer before returning.
        dp[n] = ans;

        return ans;
    }
}
