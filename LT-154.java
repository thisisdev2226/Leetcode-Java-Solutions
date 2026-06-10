/**
 * Problem: 154. Find Minimum in Rotated Sorted Array II
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Approach:
 * - Use Binary Search to locate the minimum element in a rotated sorted array
 *   that may contain duplicates.
 * - If nums[mid] > nums[right], the minimum lies in the right half,
 *   so move left to mid + 1.
 * - If nums[mid] < nums[right], the minimum lies in the left half
 *   (including mid), so move right to mid.
 * - If nums[mid] == nums[right], duplicates make it impossible to determine
 *   the correct half, so decrement right to shrink the search space.
 * - When left == right, it points to the minimum element.
 *
 * Time Complexity:
 * - Average Case: O(log n)
 * - Worst Case: O(n) when many duplicates exist
 *
 * Space Complexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}
