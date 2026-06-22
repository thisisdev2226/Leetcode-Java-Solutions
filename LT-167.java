/*
Problem: 167. Two Sum II - Input Array Is Sorted
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Approach:
- Since the array is sorted, use the Two Pointers technique.
- Initialize one pointer at the beginning (left) and another at the end (right).
- Calculate the sum of elements at both pointers:
  - If sum == target, return their 1-based indices.
  - If sum < target, move left pointer forward to increase the sum.
  - If sum > target, move right pointer backward to decrease the sum.
- Continue until the pair is found.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[2];
    }
}
