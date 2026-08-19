/*
Problem: 2824. Count Pairs Whose Sum is Less than Target
Link: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

Approach:
1. Sort the array.
2. Use two pointers:
   - i starts from the beginning.
   - j starts from the end.
3. If nums[i] + nums[j] < target, then all elements from i+1 to j
   will also form valid pairs with nums[i].
4. Therefore, add (j - i) to the count and move i forward.
5. Otherwise, decrease j.

Time Complexity: O(n log n)
Space Complexity: O(1) excluding sorting space
*/

class Solution {
    public int countPairs(List<Integer> nums, int target) {

        // Sort the list
        Collections.sort(nums);

        int count = 0;

        // Two pointers
        int i = 0;
        int j = nums.size() - 1;

        while (i < j) {

            // Valid pair
            if (nums.get(i) + nums.get(j) < target) {

                // All pairs from i to j are valid
                count += j - i;

                // Move left pointer forward
                i++;
            } else {

                // Sum is too large, move right pointer backward
                j--;
            }
        }

        return count;
    }
}
