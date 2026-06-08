/**
 * LeetCode 152 - Maximum Product Subarray
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 *
 * Approach:
 * - Keep track of both the maximum and minimum product ending at the current index.
 * - This is necessary because a negative number can turn a small negative product
 *   into a large positive product.
 * - For each element, calculate:
 *      1. Current element itself
 *      2. Current element × previous maximum product
 *      3. Current element × previous minimum product
 * - Update maxEnding, minEnding, and the overall result accordingly.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {

        int minEnding = nums[0];
        int maxEnding = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];

            maxEnding = Math.max(v1, Math.max(v2, v3));
            minEnding = Math.min(v1, Math.min(v2, v3));

            result = Math.max(result, maxEnding);
        }

        return result;
    }
}
