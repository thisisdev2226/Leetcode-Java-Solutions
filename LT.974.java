/*
 * Problem: 974. Subarray Sums Divisible by K
 * Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * Approach:
 * - Use Prefix Sum + HashMap.
 * - Store the frequency of each remainder (prefixSum % k).
 * - If the same remainder occurs again, the subarray between
 *   those two prefix sums is divisible by k.
 * - Initialize remainder 0 with frequency 1 to handle subarrays
 *   starting from index 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Empty prefix has remainder 0
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum % k;

            // Handle negative numbers
            if (rem < 0) {
                rem += k;
            }

            // Same remainder => subarray sum is divisible by k
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            // Increase frequency of this remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
