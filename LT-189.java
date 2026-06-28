/*
 * Problem: 189. Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/
 *
 * Approach:
 * - Use the Reversal Algorithm to rotate the array in-place.
 * - First, reverse the entire array.
 * - Then, reverse the first k elements.
 * - Finally, reverse the remaining (n - k) elements.
 * - Take k % n to handle cases where k is greater than the array length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    // Helper method to reverse a portion of the array
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Handle cases where k is greater than the array size
        k = k % n;

        // Reverse the entire array
        reverse(nums, 0, n - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }
}
