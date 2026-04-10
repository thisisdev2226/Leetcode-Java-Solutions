class Solution {

    /*
    LeetCode 35 - Search Insert Position
    Link: https://leetcode.com/problems/search-insert-position/

    Approach:
    - Use Binary Search since the array is sorted.
    - Initialize low = 0 and high = n - 1.
    - While low <= high:
        - Calculate mid = low + (high - low) / 2 (to avoid overflow).
        - If nums[mid] == target → return mid.
        - If nums[mid] > target → search left (high = mid - 1).
        - Else → search right (low = mid + 1).
    - If target is not found, return low.
      (low will be the correct insert position).

    Time Complexity: O(log n)
    Space Complexity: O(1)
    */

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low; // insert position
    }
}
