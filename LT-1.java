/*
Problem: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/
Approach: HashMap (One Pass)
Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // check if complement exists
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // store number and index
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
