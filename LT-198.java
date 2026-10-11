/*
Problem: 198. House Robber
Link: https://leetcode.com/problems/house-robber/

Approach:
1. Create a 1D dp array of size n because only idx changes in the recursive function.
2. Initialize dp with -1 to indicate that a subproblem has not been solved yet.
3. If idx >= n, return 0 because there are no houses left to rob.
4. If dp[idx] != -1, return the previously calculated result.
5. Take the current house:
   nums[idx] + robFrom(nums, idx + 2, dp)
6. Skip the current house:
   robFrom(nums, idx + 1, dp)
7. Store and return the maximum of take and skip in dp[idx].

Time Complexity: O(n)
Space Complexity: O(n) for the dp array and O(n) recursion stack.
*/

class Solution {

    public int rob(int[] nums) {
        // idx varies from 0 to n-1, so we create a dp array of size n.
        // dp[idx] stores the maximum money we can rob starting from idx.

        int[] dp = new int[nums.length];

        // Only one variable (idx) changes, so we use 1D DP.
        Arrays.fill(dp, -1);

        return robFrom(nums, 0, dp);
    }

    private int robFrom(int[] nums, int idx, int[] dp) {

        // Base case: no houses left.
        if (idx >= nums.length) {
            return 0;
        }

        // Return the already calculated result.
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Choice 1: Rob the current house and skip the next house.
        int takeFirst = nums[idx] + robFrom(nums, idx + 2, dp);

        // Choice 2: Skip the current house.
        int skipFirst = robFrom(nums, idx + 1, dp);

        // Store the maximum result and return it.
        return dp[idx] = Math.max(takeFirst, skipFirst);
    }
}
