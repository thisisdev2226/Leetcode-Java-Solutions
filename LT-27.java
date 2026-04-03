/**
 * Problem: 27. Remove Element
 * Link: https://leetcode.com/problems/remove-element/
 *
 * Approach:
 * - Use two pointers:
 *   1. Iterate through array using index i
 *   2. Maintain a 'count' pointer for valid elements
 * - If nums[i] != val:
 *     → Copy nums[i] to nums[count]
 *     → Increment count
 * - This shifts all non-val elements to the front
 * - Return count as new length
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    static int removeElement(int[] nums, int val){
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
