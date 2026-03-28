/**
 * Problem: 11. Container With Most Water
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Approach:
 * - Use Two Pointer technique.
 * - Start with left pointer at 0 and right pointer at n-1.
 * - Calculate area using:
 *      min(height[left], height[right]) * (right - left)
 * - Move the pointer pointing to the smaller height
 *   because increasing width is not possible, only height can improve.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
