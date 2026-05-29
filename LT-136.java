/**
 * Problem: 136. Single Number
 * Link: https://leetcode.com/problems/single-number/
 *
 * Approach:
 * - Use XOR operation to find the unique element.
 * - XOR of a number with itself becomes 0.
 * - XOR of a number with 0 remains the same.
 * - Since every element appears twice except one,
 *   all duplicate numbers cancel each other out.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {

        // Store result in first element initially
        int sign = nums[0];

        // Traverse remaining elements
        for (int i = 1; i < nums.length; i++) {

            // XOR current element with result
            // A ^ A = 0
            // 0 ^ A = A
            sign = sign ^ nums[i];
        }

        return sign;
    }
}
