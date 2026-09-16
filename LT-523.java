/*
Problem: 523. Continuous Subarray Sum
Link: https://leetcode.com/problems/continuous-subarray-sum/

Approach:
- Use Prefix Sum + HashMap of remainder -> first index.
- If two prefix sums have the same remainder when divided by k,
  their difference is divisible by k.
- Store only the FIRST occurrence of each remainder because it gives
  the longest possible subarray.
- Initialize remainder 0 at index -1 to handle subarrays starting from index 0.
- A valid subarray must contain at least 2 elements, so:
      i - previousIndex >= 2

Example:
nums = [23, 2, 4, 6, 7], k = 6

Prefix remainders:
23 % 6 = 5
25 % 6 = 1
29 % 6 = 5  -> remainder 5 already exists
                    difference in indices = 2
                    => subarray [2, 4] has sum 6

Time Complexity: O(n)
Space Complexity: O(min(n, k))
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // Convert prefix sum into remainder
            if (k != 0) {
                sum = sum % k;
            }

            // Same remainder => subarray sum is divisible by k
            if (map.containsKey(sum)) {

                if (i - map.get(sum) >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return false;
    }
}
