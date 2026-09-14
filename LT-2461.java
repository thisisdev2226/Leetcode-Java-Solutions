/*
Problem: 2461. Maximum Sum of Distinct Subarrays With Length K
Link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

Approach:

* Use a fixed-size Sliding Window with a HashSet.
* The window must contain exactly k distinct elements.
* If the current element is already present OR the window already has k elements,
  remove elements from the left until it becomes valid.
* Maintain the current window sum using `currSum`.
* When the window size becomes k, update the maximum sum.

Time Complexity: O(n)
Space Complexity: O(k)
*/

class Solution {
public long maximumSubarraySum(int[] nums, int k) {

    HashSet<Integer> set = new HashSet<>();

    long currSum = 0;
    long maxSum = 0;

    int left = 0;

    for (int right = 0; right < nums.length; right++) {

        // Remove elements if duplicate exists
        // or window already has k elements
        while (set.contains(nums[right]) || set.size() == k) {

            currSum -= nums[left];
            set.remove(nums[left]);

            left++;
        }

        // Add current element
        currSum += nums[right];
        set.add(nums[right]);

        // Valid window: exactly k distinct elements
        if (set.size() == k) {
            maxSum = Math.max(maxSum, currSum);
        }
    }

    return maxSum;
}

}
