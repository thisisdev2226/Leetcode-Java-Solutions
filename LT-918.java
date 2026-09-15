/*
Problem: 918. Maximum Sum Circular Subarray
Link: https://leetcode.com/problems/maximum-sum-circular-subarray/

Approach:
- Use Kadane's Algorithm twice:
  1. Find the maximum normal subarray sum.
  2. Find the minimum subarray sum.
- For a circular subarray:
      circularSum = totalSum - minSum
- The answer is the maximum of:
      maxSum
      totalSum - minSum
- Special case:
  If all numbers are negative, `totalSum - minSum` becomes 0,
  which represents an empty subarray. Therefore, return `maxSum`.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int maxEnding = 0;
        int minEnding = 0;

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {

            // Kadane's Algorithm for maximum subarray
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            // Kadane's Algorithm for minimum subarray
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);

            // Calculate total sum
            totalSum += num;
        }

        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Normal maximum OR circular maximum
        return Math.max(maxSum, totalSum - minSum);
    }
}
