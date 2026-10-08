/*
Problem: 494. Target Sum
Link: https://leetcode.com/problems/target-sum/

Approach:
1. At every index, we have two choices:
   - Add nums[idx] to the sum.
   - Subtract nums[idx] from the sum.
2. Instead of storing the current sum directly in a 2D array,
   use a HashMap to store (idx, target) states.
3. If the same state occurs again, return the already calculated answer.
4. When idx reaches nums.length:
   - If target == 0, we found one valid way.
   - Otherwise, return 0.

Time Complexity: O(n * S)
Space Complexity: O(n * S)

where S is the range of possible sums.
*/

class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        HashMap<String, Integer> dp = new HashMap<>();

        return helper(nums, 0, target, dp);
    }

    public int helper(int[] nums, int idx, int target,
                      HashMap<String, Integer> dp) {

        // Base case
        if (idx == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // Create a unique key for current state
        String key = idx + "," + target;

        // If already calculated
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Choose '+'
        // Remaining target becomes target - nums[idx]
        int add = helper(nums, idx + 1,
                         target - nums[idx], dp);

        // Choose '-'
        // Remaining target becomes target + nums[idx]
        int subtract = helper(nums, idx + 1,
                              target + nums[idx], dp);

        // Store answer for this state
        dp.put(key, add + subtract);

        return add + subtract;
    }
}
