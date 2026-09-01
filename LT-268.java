/*
    Problem: 268. Missing Number
    Link: https://leetcode.com/problems/missing-number/

    Approach:
    - The array contains n distinct numbers from the range [0, n].
    - XOR all indices and array elements together.
    - Since XOR of the same numbers becomes 0, all matching numbers cancel out.
    - The remaining value is the missing number.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }
}
