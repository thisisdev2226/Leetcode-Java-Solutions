/*
Problem: Subset XOR Sum (LeetCode 1863)
Link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/

Approach:
1. Use Recursion (Pick / Not Pick) to generate all possible subsets.
2. Maintain `idx` to track the current array index.
3. Maintain `xt` to store the XOR of the current subset.
4. Take: Include the current element in the subset using XOR.
5. Not Take: Exclude the current element from the subset.
6. Base Case: When idx == nums.length, add the current XOR value to sum.
7. Return sum after exploring all possible subsets.

Time Complexity: O(2^n)
- Each element has two choices: Take or Not Take.
- Total subsets = 2^n.

Space Complexity: O(n)
- Recursion stack can go up to n levels.
*/

class Solution {
  
    int sum = 0;
    int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;

        sol(0, 0);

        return sum;
    }

    private void sol(int idx, int xt) {

        if (idx == nums.length) {
            sum += xt;
            return;
        }

        // Take: Include the current element in the subset
        sol(idx + 1, xt ^ nums[idx]);

        // Not Take: Exclude the current element from the subset
        sol(idx + 1, xt);
    }
}
