/*
 * LeetCode 456: 132 Pattern
 *
 * Link: https://leetcode.com/problems/132-pattern/
 *
 * Approach:
 * - Traverse the array from right to left.
 * - Use a monotonic decreasing stack to maintain possible "2" values.
 * - num3 stores the largest possible "2" value found so far.
 * - If nums[i] < num3, then we have:
 *      nums[i] < num3 < some previous stack value
 *   which forms the required 132 pattern.
 *
 * Why traverse from right?
 * - We need i < j < k.
 * - Traversing from right to left naturally allows us to find
 *   the "2" and "3" elements using the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;
        int num3 = Integer.MIN_VALUE;

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // nums[i] acts as "1"
            if (nums[i] < num3) {
                return true;
            }

            // Find a valid "2" for the current "3"
            while (!st.isEmpty() && nums[i] > st.peek()) {
                num3 = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}
