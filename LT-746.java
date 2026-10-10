/*
Problem: 746. Min Cost Climbing Stairs
Link: https://leetcode.com/problems/min-cost-climbing-stairs/

Approach:
1. We can reach stair n by taking either one step or two steps from the previous stairs.
2. dp[i] represents the minimum cost required to reach stair i.
3. Initialize dp[0] = 0 and dp[1] = 0 because we can start from either stair without paying any cost.
4. For every stair from 2 to n:
   - One step: cost[i-1] + dp[i-1]
   - Two steps: cost[i-2] + dp[i-2]
5. Store the minimum of both choices in dp[i].
6. Return dp[n].

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 0;

        // Bottom-up DP
        for (int state = 2; state <= n; state++) {
            int oneStep = cost[state - 1] + dp[state - 1];
            int twoStep = cost[state - 2] + dp[state - 2];

            dp[state] = Math.min(oneStep, twoStep);
        }

        return dp[n];
    }
}
