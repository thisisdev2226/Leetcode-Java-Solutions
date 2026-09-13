/*
Problem: 724. Find Pivot Index
Link: https://leetcode.com/problems/find-pivot-index/

Approach:
- Calculate the total sum of the array.
- Maintain a running leftSum.
- At index i:
    rightSum = totalSum - leftSum - nums[i]
- If leftSum == rightSum, i is the pivot index.
- Otherwise, add nums[i] to leftSum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int pivotIndex(int[] nums) {

        // Calculate total sum
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Running sum of elements on the left
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current element is excluded from both sides
            int rightSum = totalSum - leftSum - nums[i];

            // Found pivot index
            if (leftSum == rightSum) {
                return i;
            }

            // Add current element to left side
            leftSum += nums[i];
        }

        return -1;
    }
}
