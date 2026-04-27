/**
 * Problem: 81. Search in Rotated Sorted Array II
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Approach:
 * - Modified Binary Search.
 * - At each step, check which half is sorted.
 *
 * Cases:
 * 1. If nums[mid] == target → return true.
 *
 * 2. If nums[st] == nums[mid] == nums[end]:
 *    → Cannot decide sorted half due to duplicates.
 *    → Shrink search space: st++, end--
 *
 * 3. If left half is sorted (nums[st] <= nums[mid]):
 *    → Check if target lies in left half
 *        - If yes → search left (end = mid - 1)
 *        - Else → search right (st = mid + 1)
 *
 * 4. Else right half is sorted:
 *    → Check if target lies in right half
 *        - If yes → search right (st = mid + 1)
 *        - Else → search left (end = mid - 1)
 *
 * Time Complexity:
 * - Average: O(log n)
 * - Worst case (due to duplicates): O(n)
 *
 * Space Complexity: O(1)
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) return true;

            // Case: duplicates (cannot determine sorted half)
            if (nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
            }
            // Left half sorted
            else if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
