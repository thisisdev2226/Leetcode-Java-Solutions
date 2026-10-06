/*
Problem: 1929. Concatenation of Array
Link: https://leetcode.com/problems/concatenation-of-array/

Approach:
1. Create an array `ans` of size `2 * n`.
2. Traverse the original array once.
3. Put `nums[i]` at:
   - `ans[i]` → first copy
   - `ans[i + n]` → second copy
4. Return `ans`.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
