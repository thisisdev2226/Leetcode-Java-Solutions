/*
Problem: 1749. Maximum Absolute Sum of Any Subarray
Link: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

Approach:
- Use Kadane's Algorithm twice:
  1. maxEnding / maxSum -> maximum subarray sum.
  2. minEnding / minSum -> minimum subarray sum.
- The maximum absolute sum is the larger of:
  - absolute maximum subarray sum
  - absolute minimum subarray sum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxEnding = 0;
        int minEnding = 0;

        int maxSum = 0;
        int minSum = 0;

        for (int num : nums) {

            // Maximum subarray sum (Kadane)
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            // Minimum subarray sum
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
