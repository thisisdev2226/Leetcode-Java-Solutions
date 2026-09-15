/*
Problem: 209. Minimum Size Subarray Sum
Link: https://leetcode.com/problems/minimum-size-subarray-sum/

Approach:
- Use the Sliding Window / Two Pointer technique.
- Expand the window by moving `right` and add nums[right] to currSum.
- When currSum >= target, the window is valid.
- Update minLen and shrink the window from the left to find the minimum length.
- If no valid subarray exists, return 0.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        // Sliding Window / Two Pointer
        for (int right = 0; right < nums.length; right++) {

            // Expand window
            currSum += nums[right];

            // Shrink window while condition is satisfied
            while (currSum >= target) {

                // Update minimum window length
                minLen = Math.min(minLen, right - left + 1);

                // Remove left element
                currSum -= nums[left];
                left++;
            }
        }

        // Return 0 if no valid subarray exists
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
