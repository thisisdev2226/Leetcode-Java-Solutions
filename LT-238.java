/*
Problem: 238. Product of Array Except Self

Link: https://leetcode.com/problems/product-of-array-except-self/

Approach:
1. Create two arrays, left[] and right[], to store prefix and suffix products.
2. Initialize left[0] = 1 because there are no elements before index 0.
3. Traverse from left to right:
   - left[i] = left[i-1] * nums[i-1]
   - Store the product of all elements before the current index.
4. Initialize right[n-1] = 1 because there are no elements after the last index.
5. Traverse from right to left:
   - right[i] = right[i+1] * nums[i+1]
   - Store the product of all elements after the current index.
6. Create an answer array.
7. For every index, multiply left[i] and right[i] to get the product of all elements except nums[i].
8. Return the answer array.

Time Complexity: O(n)
- One traversal to calculate left products.
- One traversal to calculate right products.
- One traversal to generate the answer.

Space Complexity: O(n)
- left[], right[], and ans[] arrays are used.
- Auxiliary space is O(n).

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // No elements exist before index 0
        left[0] = 1;

        // Calculate prefix products
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // No elements exist after the last index
        right[nums.length - 1] = 1;

        // Calculate suffix products
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];

        // Multiply left and right products
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
