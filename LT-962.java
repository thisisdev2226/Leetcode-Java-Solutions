/*
 * Problem: 962. Maximum Width Ramp
 * Link: https://leetcode.com/problems/maximum-width-ramp/
 *
 * Approach:
 * - Use a monotonic decreasing stack to store indices.
 * - The stack contains indices where nums[i] forms a decreasing sequence.
 * - Traverse from right to left.
 * - For every j, while nums[stack.peek()] <= nums[j], we found a valid ramp.
 * - Calculate width = j - i and pop the index because this i cannot give
 *   a better width with any smaller j.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxWidthRamp(int[] nums) {

        // Monotonic decreasing stack of indices
        Stack<Integer> st = new Stack<>();

        int n = nums.length;

        // Build decreasing stack from left to right
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[st.peek()] >= nums[i]) {
                st.push(i);
            }
        }

        int width = 0;
        int j = n - 1;

        // Traverse from right to left
        while (j >= 0) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[j]) {

                int i = st.pop();

                width = Math.max(width, j - i);
            }

            j--;
        }

        return width;
    }
}
