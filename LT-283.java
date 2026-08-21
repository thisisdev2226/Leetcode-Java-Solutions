/*
Problem: 283. Move Zeroes
Link: https://leetcode.com/problems/move-zeroes/

Approach:
- Use two pointers:
  i -> Points to the position where the next non-zero element should go.
  j -> Traverses the entire array.
- Whenever nums[j] is non-zero, swap nums[i] and nums[j].
- Increment i after placing a non-zero element.
- This automatically moves all zeroes to the end.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {

        // i points to the next position for a non-zero element
        int i = 0;

        // j traverses the array
        for (int j = 0; j < nums.length; j++) {

            // If current element is non-zero
            if (nums[j] != 0) {

                // Swap nums[i] and nums[j]
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                // Move i to the next position
                i++;
            }
        }
    }
}
