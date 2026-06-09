/**
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Approach:
 * - Use Binary Search to locate the minimum element.
 * - Compare the middle element with the rightmost element.
 * - If nums[mid] > nums[right], the minimum lies in the right half,
 *   so move left = mid + 1.
 * - Otherwise, the minimum lies in the left half (including mid),
 *   so move right = mid.
 * - Continue until left == right, which points to the minimum element.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
