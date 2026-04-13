import java.util.*;

class Solution {

    /*
    Problem No: 39
    Problem Name: Combination Sum
    Link: https://leetcode.com/problems/combination-sum/

    Approach:
    - Use Backtracking (Recursion)
    - At each index, we have 2 choices:
        1. Pick the element (if <= target) → stay on same index
        2. Skip the element → move to next index
    - Base Case:
        - If idx == arr.length:
            - If target == 0 → valid combination → add to answer
    - Backtrack by removing last added element

    Time Complexity:
    - Exponential (~ O(2^target))

    Space Complexity:
    - O(k * x) + recursion stack
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        findCombinations(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private void findCombinations(int idx, int[] arr, int target,
                                 List<List<Integer>> ans, List<Integer> ds) {

        // Base Case
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // store valid combination
            }
            return;
        }

        // Pick the element (if possible)
        if (arr[idx] <= target) {
            ds.add(arr[idx]); // choose

            findCombinations(idx, arr, target - arr[idx], ans, ds); // stay on same index

            ds.remove(ds.size() - 1); // backtrack (undo)
        }

        // Not pick the element
        findCombinations(idx + 1, arr, target, ans, ds);
    }
}
