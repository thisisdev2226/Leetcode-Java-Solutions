/*
 * Problem: 643. Maximum Average Subarray I
 * Link: https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * Approach:
 * - Use the Sliding Window technique.
 * - Maintain a window of exactly size k.
 * - Add nums[right] to the current sum.
 * - When the window size becomes k:
 *      1. Update maxSum.
 *      2. Remove nums[left] from the window.
 *      3. Move left forward.
 * - Finally, divide maxSum by k to get the maximum average.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int sum = 0;

        // Stores the maximum sum of any window of size k
        int maxSum = Integer.MIN_VALUE;

        // Sliding Window
        for (int right = 0; right < nums.length; right++) {

            // Add current element to the window
            sum += nums[right];

            // When window size becomes k
            if (right - left + 1 == k) {

                // Update maximum window sum
                maxSum = Math.max(sum, maxSum);

                // Remove the leftmost element
                // before sliding the window forward
                sum -= nums[left];

                // Move left pointer
                left++;
            }
        }

        // Average = maximum sum / window size
        return (double) maxSum / k;
    }
}
