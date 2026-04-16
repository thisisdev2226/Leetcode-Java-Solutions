/*
Problem: 53. Maximum Subarray
Link: https://leetcode.com/problems/maximum-subarray/

Approach:
- Use Kadane’s Algorithm.
- Maintain two variables:
  1. curr_max → maximum sum ending at current index
  2. max_so_far → overall maximum subarray sum
- At each step:
  - Either extend the current subarray OR start a new one from current element
  - Update the global maximum

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
