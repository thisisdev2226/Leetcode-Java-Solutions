/*
 * Problem: 977. Squares of a Sorted Array
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Approach:
 * - The input array is sorted, but after squaring, negative values can
 *   become larger than positive values.
 * - The largest square will always come from either the left end
 *   (negative number) or the right end (positive number).
 * - Use two pointers:
 *      i -> start of array
 *      j -> end of array
 * - Compare the squares of nums[i] and nums[j].
 * - Put the larger square at the end of the result array.
 * - Move the corresponding pointer and move k backwards.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        int i = 0;          // Left pointer
        int j = n - 1;      // Right pointer

        int[] res = new int[n];

        // Fill result from the end because largest squares come first
        int k = n - 1;

        while (i <= j) {

            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];

            // Put the larger square at the current end position
            if (leftSq > rightSq) {
                res[k] = leftSq;
                i++;
            } else {
                res[k] = rightSq;
                j--;
            }

            k--;
        }

        return res;
    }
}
