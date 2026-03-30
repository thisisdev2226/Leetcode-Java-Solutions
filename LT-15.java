/*
Problem: 15. 3Sum
Link: https://leetcode.com/problems/3sum/

Approach:
- Sort the array.
- Fix one element and use two pointers (left & right) to find pairs.
- If sum == 0 → add triplet.
- If sum < 0 → move left pointer.
- If sum > 0 → move right pointer.
- Skip duplicates to avoid repeated triplets.

Time Complexity: O(n^2)
Space Complexity: O(1) (excluding result list)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        if (arr == null || arr.length < 3) {
            return result;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            // Skip duplicate elements
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
