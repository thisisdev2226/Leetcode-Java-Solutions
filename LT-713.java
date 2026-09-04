/*
Problem: 713. Subarray Product Less Than K
Link: https://leetcode.com/problems/subarray-product-less-than-k/

Approach:
1. Use a sliding window with two pointers: left and right.
2. Keep multiplying elements as right moves forward.
3. If product >= k, shrink the window from the left by dividing
   nums[left] and moving left forward.
4. For every valid window [left ... right], the number of valid
   subarrays ending at right is:

      right - left + 1

   Example:
   nums = [10, 5, 2], k = 100

   When right = 1:
   window = [10, 5]

   Valid subarrays ending at index 1:
      [5]
      [10, 5]

   Count = 1 - 0 + 1 = 2

5. Add this count to the total answer.

Why k <= 1?
All numbers are positive, so every subarray product is at least 1.
Therefore, no product can be less than k when k <= 1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // If k <= 1, no positive product can be less than k
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {

            // Add current element to the window
            product *= nums[right];

            // Shrink window until product becomes < k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // Number of valid subarrays ending at 'right'
            count += (right - left) + 1;
        }

        return count;
    }
}
```
