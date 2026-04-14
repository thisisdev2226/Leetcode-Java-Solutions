/**
 * Problem: 46. Permutations
 * Link: https://leetcode.com/problems/permutations/
 *
 * Approach:
 * - Use Backtracking.
 * - Maintain:
 *   1. ds (current permutation list)
 *   2. isValid[] (to track used elements)
 *
 * - For each index:
 *   - If element is not used:
 *       -> Add it to ds
 *       -> Mark it as used
 *       -> Recurse
 *       -> Backtrack (remove + mark unused)
 *
 * - Base Case:
 *   - When ds.size() == nums.length → add a copy of ds to result
 *
 * Time Complexity: O(n! * n)
 * Space Complexity: O(n)
 */

class Solution {

    public void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
        
        // Base Case
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds)); // direct copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isValid[i]) {
                
                // Choose
                ds.add(nums[i]);
                isValid[i] = true;

                // Explore
                helper(nums, ds, isValid, ans);

                // Backtrack
                isValid[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];

        helper(nums, new ArrayList<>(), isValid, ans);
        return ans;
    }
}
