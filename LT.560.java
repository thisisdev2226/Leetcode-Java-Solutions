/*
Problem: 560. Subarray Sum Equals K
Link: https://leetcode.com/problems/subarray-sum-equals-k/

Approach:
- Use Prefix Sum + HashMap.
- Store: prefixSum → frequency of occurrence.
- For current prefix sum, if (sum - k) exists, then those previous
  prefix sums form subarrays having sum = k.
- map.put(0, 1) handles subarrays starting from index 0.
- Store the current prefix sum after checking.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 occurs once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            // Calculate prefix sum
            sum += num;

            // Check if a previous prefix sum = sum - k exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store/update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
