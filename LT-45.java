/**
 * Problem: 45. Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/
 *
 * Approach:
 * - Greedy approach.
 * - Maintain three variables:
 *   1. current: end of current jump range
 *   2. farthest: farthest index reachable so far
 *   3. jumps: number of jumps taken
 *
 * - Iterate through array (except last index):
 *   - Update farthest = max(farthest, i + nums[i])
 *   - If we reach current boundary:
 *       -> Increase jump count
 *       -> Update current = farthest
 *
 * - This ensures minimum jumps by always jumping to the farthest reachable point.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int current = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == current) {
                current = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
