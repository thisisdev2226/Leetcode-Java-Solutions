/*
Problem: 3151. Special Array I
Link: https://leetcode.com/problems/special-array-i/

Approach:
1. If the array contains only one element, return true because there is no adjacent pair to check.
2. Traverse the array from index 0 to n-2.
3. Check the parity of every pair of adjacent elements.
4. If both adjacent elements have the same parity (both even or both odd), return false.
5. If all adjacent elements have different parity, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }

        return true;
    }
}
