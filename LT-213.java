/*
Problem: 213. House Robber II
Link: https://leetcode.com/problems/house-robber-ii/

Approach:
1. Since the houses are arranged in a circle, the first and last houses are adjacent.
2. We cannot rob both the first and last houses.
3. Consider two cases:
   - Case 1: Rob houses from index 0 to n-2.
   - Case 2: Rob houses from index 1 to n-1.
4. Use recursion with memoization to calculate the maximum money for each case.
5. Return the maximum of both cases.

Time Complexity: O(n)
Space Complexity: O(n) for the DP arrays and recursion stack.
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Case 1: Rob houses from 0 to n-2
        int case1 = helper(nums, 0, n - 2, dp1);

        // Case 2: Rob houses from 1 to n-1
        int case2 = helper(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    private int helper(int[] nums, int start, int end, int[] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        // Rob the current house
        int rob = nums[start] + helper(nums, start + 2, end, dp);

        // Skip the current house
        int skip = helper(nums, start + 1, end, dp);

        return dp[start] = Math.max(rob, skip);
    }
}
