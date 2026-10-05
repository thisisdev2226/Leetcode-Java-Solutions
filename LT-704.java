/*
Problem: 704. Binary Search
Link: https://leetcode.com/problems/binary-search/

Approach:
1. Use two pointers, low and high, to represent the current search range.
2. Find the middle index using low + (high - low) / 2.
3. If nums[mid] == target, return mid.
4. If nums[mid] < target, search in the right half.
5. Otherwise, search in the left half.
6. If the target is not found, return -1.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
