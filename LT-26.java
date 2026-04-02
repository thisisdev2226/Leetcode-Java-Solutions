/**
 * Problem: 26. Remove Duplicates from Sorted Array
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Approach:
 * - Use two pointers:
 *      i → tracks the last unique element
 *      j → scans the array
 * - If nums[j] != nums[i], it means we found a new unique element:
 *      - Increment i
 *      - Copy nums[j] to nums[i]
 * - This ensures all unique elements are moved to the front of the array.
 * - Return i + 1 because i is index, not count.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
