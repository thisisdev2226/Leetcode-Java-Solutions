/**
 * Problem: 55. Jump Game
 * Link: https://leetcode.com/problems/jump-game/
 *
 * Approach:
 * - Use a greedy strategy starting from the end.
 * - Maintain a variable `last` which represents the last index we need to reach.
 * - Traverse the array from right to left:
 *   - If current index `i` can reach `last` (i + nums[i] >= last),
 *     update `last = i`.
 * - At the end, check if we can move `last` to index 0.
 *
 * Intuition:
 * - Instead of checking from start → end, we reverse the thinking.
 * - We keep shifting the goalpost (last) backward whenever possible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public static boolean canJump(int[] nums) {

        int last = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }
}
