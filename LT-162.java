/**
 * Problem: 162. Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/
 *
 * Approach:
 * - Use Binary Search to find a peak element.
 * - Compare nums[mid] with nums[mid + 1].
 * - If nums[mid] < nums[mid + 1], a peak must exist on the right side,
 *   so move left = mid + 1.
 * - Otherwise, a peak exists on the left side (including mid),
 *   so move right = mid.
 * - When left == right, we have found a peak index.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
